package com.appsinventive.satsangserver.controllers;


import com.appsinventive.satsangserver.Utils.MongoConstants;
import com.appsinventive.satsangserver.Utils.OnlineSAConstants;
import com.appsinventive.satsangserver.pojo.*;
import com.appsinventive.satsangserver.repository.FamilyIdSequenceReposiroty;
import com.appsinventive.satsangserver.repository.RitviksRepository;
import com.appsinventive.satsangserver.repository.UserRepository;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final ThreadLocal<Random> random = new ThreadLocal<Random>();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RitviksRepository ritviksRepository;
    @Autowired
    private FamilyIdSequenceReposiroty familyIdSequenceReposiroty;

    @RequestMapping("/register")
    public String register(@RequestBody String primaryUserDetails) {
//        getFamilyIDSequenceForSeqName();

//        String familyId=payload.get("familyId");

        try {
            RootMDB root = new RootMDB();
            JSONObject obj = new JSONObject(primaryUserDetails);
//            return obj.getString("firstName").toUpperCase();
//            root.set_id(getSeqID());
            root.setFirstName(obj.getString("firstName").toUpperCase());

            if (obj.has(("middleName")))
                root.setMiddleName(obj.getString("middleName").toUpperCase());

            if (obj.has("lastName"))
                root.setLastName(obj.getString("lastName").toUpperCase());

            if (obj.has("familyCode"))
                root.setIndfamilyCode(obj.getString("familyCode").toUpperCase());

            if (obj.has("emailID"))
                root.setEmail(obj.getString("emailID").toUpperCase());

            if (obj.has("pwd")) {
//                String passwordRequest = obj.getString("pwd");
//                String passwordHash = makePasswordHash(passwordRequest, "123");
//                root.setPassword(passwordHash);
                root.setPassword(obj.getString("pwd"));
            }

            if (obj.has("phoneNo"))
                root.setPhoneNo(obj.getString(("phoneNo")));

            if (obj.has("rName"))
                root.setrName(obj.getString(("rName")).toUpperCase());


            AddressMDB address = new AddressMDB();

            if (obj.has("add1"))
                address.setAddressLine1(obj.getString("add1").toUpperCase());

            if (obj.has("add2"))
                address.setAddressLine2(obj.getString("add2").toUpperCase());

            if (obj.has("add3"))
                address.setAddressLine3(obj.getString("add3").toUpperCase());

            if (obj.has("city"))
                address.setCity(obj.getString("city").toUpperCase());


            if (obj.has("country")) {

                address.setCountry(obj.getString("country").toUpperCase());
            }

            if (obj.has("state")) {
                address.setCountry(obj.getString("state").toUpperCase());

            }

            if (obj.has("zipCode"))
                address.setZipCode(obj.getString("zipCode"));

            root.setAddress(address);

            root.setFamilyID(getFamilyIDSequenceForSeqName());
            root.setPersonalId(root.getFamilyID() + "-" + "01");
            root.setPprFlag(OnlineSAConstants.YES); // By Default it will be Yes amnd e receipt will be generated.
            root.setUserType(OnlineSAConstants.PORTAL_USER); // by default all users will have portal access only
            root.setPersonalize(root.getFirstName() + " DADA");   // by default all users will have portal access only
            userRepository.save(root);
            Gson gson = new Gson();
            String output = gson.toJson(root);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 200);
            map.put("user", root);
            map.put("message", "none");
            return gson.toJson(map);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getFamilyIDSequenceForSeqName() {
        List<FamilyIDSequence> list = familyIdSequenceReposiroty.findAll();
        FamilyIDSequence last = list.get(list.size() - 1);

        int addOne = Integer.parseInt(last.getFamilyID().substring(3,
                last.getFamilyID().length())) + 1;
        String newId = getFamilySeqID(addOne);
        FamilyIDSequence sequence = new FamilyIDSequence();
        sequence.setFamilyID(newId);
        sequence.setFirstName("" + newId);
        familyIdSequenceReposiroty.save(sequence);
        return newId;

    }


    public String getFamilySeqID(int seqID) {
//        BigDecimal seqID=  getFamilyIDSequenceForSeqName(MongoConstants.FAMILY_SEQ);
        String familyID = null;
//        logger.info("seqID   " + seqID);
        if (Integer.valueOf(seqID) <= 9) {
            familyID = "SA000000" + seqID;
        } else if (Integer.valueOf(seqID) <= 99) {
            familyID = "SA00000" + seqID;
        } else if (Integer.valueOf(seqID) <= 999) {
            familyID = "SA0000" + seqID;
        } else if (Integer.valueOf(seqID) <= 9999) {
            familyID = "SA000" + seqID;
        } else if (Integer.valueOf(seqID) <= 99999) {
            familyID = "SA00" + seqID;
        } else if (Integer.valueOf(seqID) <= 999999) {
            familyID = "SA0" + seqID;
        } else if (Integer.valueOf(seqID) <= 999999) {
            familyID = "SA" + seqID;
        }
        return familyID;
    }
////


    public MongoCollection<RootSequence> fetchRootSequenceCollection() {
//        MongoClientOptions options = MongoClientOptions.builder()
//                .codecRegistry(codecRegistry)
//                .connectionsPerHost(100)
//                .connectTimeout(5000)
//                .threadsAllowedToBlockForConnectionMultiplier(10)
//                .maxConnectionIdleTime(600000)
//                .build();
//
//        MongoClient mongoClient = new MongoClient(serverList, credentialsList,options);
        return null;
//        return getMongoClient().getDatabase("admin").getCollection(MongoConstants.ROOT_SEQ, RootSequence.class);
    }

    private String makePasswordHash(String password, String salt) {
        try {
            String saltedAndHashed = password + "," + salt;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedAndHashed.getBytes());
            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
            byte[] enco = Base64.getEncoder().encode(hashedBytes);
            return enco + "," + salt;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 is not available", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
        }
    }

    private Random getRandom() {
        Random result = random.get();
        if (result == null) {
            result = new Random();
            random.set(result);
        }
        return result;
    }

//    public ResultObject validateLogin(String username, String password) {

//        ResultObject resultObject = new ResultObject();
//        HashMap<String, String> error = new HashMap<String, String>();
//        RootMDB getRoot = fetchRootDocument(username);
//
//        if (getRoot == null) {
//            error.put("userName", "User Not Exist");
//            resultObject.setErrors(error);
//            return resultObject;
//        }
//
//        String hashedAndSalted = getRoot.getPassword();
//        String salt="123"; // = hashedAndSalted
//        //Need to put the Salt logic
//
//        if (!hashedAndSalted.equals(makePasswordHash(password, salt))) {
////            logger.info("Submitted password is not a match");
//            error.put("password", "Invalid Password");
//            resultObject.setErrors(error);
//
//            return resultObject;
//        }
//
//        resultObject.setObject1(getRoot);
//        return resultObject;

    //    }
    @RequestMapping("/loginUser")
    public String loginUser(@RequestBody String primaryUserDetails) {

        try {
            JSONObject obj = new JSONObject(primaryUserDetails);
            List<RootMDB> allUsers = userRepository.findAll();
            HashMap<String, RootMDB> usersMap = new HashMap<>();
            for (RootMDB user : allUsers) {
                usersMap.put(user.getFamilyID(), user);
            }
            if (!usersMap.containsKey(obj.getString("familyId"))) {
                Gson gson = new Gson();
                HashMap<String, Object> map = new HashMap<>();
                map.put("code", 404);
                map.put("message", "Family Id does not exists");
                return gson.toJson(map);
            } else {
                RootMDB user = usersMap.get(obj.getString("familyId"));
//                if (makePasswordHash(obj.getString("pwd"), "123").equals(user.getPassword())) {
                if (obj.getString("pwd").equals(user.getPassword())) {
                    Gson gson = new Gson();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("code", 200);
                    map.put("user", user);
                    map.put("message", "none");
                    return gson.toJson(map);
                } else {
                    Gson gson = new Gson();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("code", 404);
                    map.put("message", "Wrong Password");
                    return gson.toJson(map);
                }
            }

        } catch (JSONException e) {


        }
        return "";
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers() {

        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @RequestMapping("/getUserData")
    public String getUserData(@RequestBody String primaryUserDetails) {
        RootMDB rootMDB = null;
        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject obj = new JSONObject(primaryUserDetails);
            List<RootMDB> list = userRepository.findAll();

            for (RootMDB user : list) {
                if (user.getFamilyID().equals(obj.getString("familyId"))) {
                    rootMDB = user;
                }
            }
            if (rootMDB != null) {
                map.put("code", 200);
                map.put("user", rootMDB);
                map.put("message", "none");
            } else {
                map.put("code", 404);
                map.put("message", "Family Id does not exists");
            }
        } catch (Exception e) {
            map.put("code", 404);
            map.put("exception", e.getMessage());
        }
        return gson.toJson(map);
    }

    @GetMapping("/getAllRitviks")
    public ResponseEntity<?> getAllRitviks() {

        return ResponseEntity.ok(this.ritviksRepository.findAll());
    }


}
