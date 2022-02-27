package com.appsinventive.satsangserver.Utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.appsinventive.satsangserver.pojo.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;


public class MongoBaseDao {
	private MongoClient mongoClient;
	public MongoClient getMongoClient() {
		return mongoClient;
	}


	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}


	public String getMongoDbName() {
		return mongoDbName;
	}


	public void setMongoDbName(String mongoDbName) {
		this.mongoDbName = mongoDbName;
	}

	private String mongoDbName;
	
	public void doBackendLogging(String detailsId, Class<?> className, String taskName, Map<String, ?> input,
			Map output, long timeElapsed) {
	}
	
	public BigDecimal getRootSequenceIdForSeqName(String sequenceName)  {
		RootSequence seqObj = fetchRootSequenceCollection().findOneAndUpdate(Filters.eq(MongoConstants.MONGO_ID, sequenceName),
				Updates.inc(MongoConstants.SEQ_VALUE, 1),
				new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true));

		if (seqObj == null || seqObj.getSeqValue() == null) {
			
		}

		return seqObj.getSeqValue();
	}

	public String getNextRitwikSeq(String sequenceName) {
		String seqCode = null;
		
	
		MongoCollection<Document> db = getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.COUNTER);  
		FindIterable<Document> result = db.find(Filters.eq(MongoConstants.CNT_SEQ_NAME, sequenceName));
		int cnt =0;
		for (Document doc : result) {
			cnt=((Double) doc.get("counter")).intValue();
		}
		String formattedCounter="";

			formattedCounter = String.format("%04d",cnt+1); 
			seqCode = "SPR"+formattedCounter;
		
		
		//Increment the sequece count
			Document seqObj = db.findOneAndUpdate(Filters.eq(MongoConstants.CNT_SEQ_NAME,sequenceName),
					Updates.inc(MongoConstants.CNT_SEQ_COUNTER, 1),
					new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true));
			
		return seqCode;
	}

	
	
	public MongoCollection<RootSequence> fetchRootSequenceCollection() {
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ROOT_SEQ, RootSequence.class);
	}


	/**
	 * function to get seq id for family
	 * @param sequenceName
	 * @return
	 */
	public BigDecimal getFamilyIDSequenceForSeqName(String sequenceName)  {
		FamilyIDSequence seqObj = fetchFamilyIDSequenceCollection().findOneAndUpdate(Filters.eq(MongoConstants.MONGO_ID, sequenceName),
				Updates.inc(MongoConstants.SEQ_VALUE, 1),
				new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true));

		if (seqObj == null || seqObj.getSeqValue() == null) {
			
		}

		return seqObj.getSeqValue();
	}
	

	/**
	 * function to get seq id for family
	 * @param sequenceName
	 * @return
	 */
	public BigDecimal getRitwikSeq(String sequenceName)  {
		FamilyIDSequence seqObj = fetchFamilyIDSequenceCollection().findOneAndUpdate(Filters.eq(MongoConstants.MONGO_ID, sequenceName),
				Updates.inc(MongoConstants.SEQ_VALUE, 1),
				new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true));

		if (seqObj == null || seqObj.getSeqValue() == null) {
			
		}

		return seqObj.getSeqValue();
	}

	public MongoCollection<FamilyIDSequence> fetchFamilyIDSequenceCollection() {
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.FAMILY_SEQ, FamilyIDSequence.class);
	}
	
	
	/***
	 * 	This method is used to fetch Isht Collection
	 * @return Isht
	 */	
	public MongoCollection<IshtMDB> fetchIshtCollection(){
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ISHT_COLLECTION,IshtMDB.class);	
	}
	
	/***
	 * 	This method is used to fetch Isht Collection
	 * @return Isht
	 */	
	public MongoCollection<ArghIshtMDB> fetchArgIshtCollection(){
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ARGH_ISHT_COLLECTION,ArghIshtMDB.class);	
	}
	
	/***
	 * 	This method is used to fetch Isht Document
	 * @return Root Document
	 */

	public IshtMDB fetchIshtDocument(String receiptNo){
		return fetchIshtCollection().find(Filters.eq("receiptNo", receiptNo), IshtMDB.class).first();
	}
	

	/***
	 * 	This method is used to fetch Isht Document
	 * @return Root Document
	 */

	public ArghIshtMDB fetchArgIshtDocument(String receiptNo){
		return fetchArgIshtCollection().find(Filters.eq("receiptNo", receiptNo), ArghIshtMDB.class).first();
	}
	
	
	
	
	/***
	 * 	This method is used to fetch Root Collection
	 * @return RootCollection
	 */	
	public MongoCollection<RootMDB> fetchRootListCollection(){
		
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ROOT_COLLECTION,RootMDB.class);	
	}
	/***
	 * 	This method is used to fetch Root Document
	 * @return Root Document
	 */

	public RootMDB fetchRootDocument1(String phoneNo){
		return fetchRootCollection().find(Filters.eq("phoneNo", phoneNo), RootMDB.class).first();
	}
	
	
	/***
	 * 	This method is used to fetch Root Document
	 * @return Root Document
	 */

	public RootMDB fetchRootDocument(String username){
		Bson filter = Filters.or(eq("phoneNo", username), eq("familyID", username));
		return fetchRootCollection().find(filter, RootMDB.class).first();
	}
	
	public RootMDB fetchRootDocument2(String familyID){
		//Bson filter = Filters.or(eq("phoneNo", username), eq("familyID", username));
		return fetchRootCollection().find(Filters.eq("familyID", familyID), RootMDB.class).first();
		//return fetchRootCollection().find(filter, RootMDB.class).first();
	}
	
	/***
	*This method implemetns like operator and returns the mulitple Documents.
	*/
	public FindIterable<RootMDB> fetchRootListDocument(String inputValue,String inputParam){
		BasicDBObject regexQuery = new BasicDBObject();

		if(inputParam.equalsIgnoreCase("phoneNo")){
			regexQuery.put("phoneNo", new BasicDBObject("$regex", inputValue).append("$options", "i"));
			//DBCursor cursor = fetchRootCollection().find(regexQuery,)
		}
		else if(inputParam.equalsIgnoreCase("familyCode")) {
			regexQuery.put("familyID", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		else if(inputParam.equalsIgnoreCase("firstName")) {
			regexQuery.put("firstName", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		else if(inputParam.equalsIgnoreCase("lastName")) {
			regexQuery.put("lastName", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		
		//return  fetchRootCollection().find(Filters.eq("phoneNo", inputValue), RootMDB.class).first();
		return fetchRootListCollection().find(regexQuery);
	}
	
	/***
	*This method implemetns like operator and returns the mulitple Documents.
	*/
	public RootMDB fetchRootDocument(String inputValue,String inputParam){
		BasicDBObject regexQuery = new BasicDBObject();
		

		if(inputParam.equalsIgnoreCase("phoneNo")){
			regexQuery.put("phoneNo", new BasicDBObject("$regex", inputValue).append("$options", "i"));
			//DBCursor cursor = fetchRootCollection().find(regexQuery,)
		}
		else if(inputParam.equalsIgnoreCase("familyCode")) {
			regexQuery.put("familyID", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		else if(inputParam.equalsIgnoreCase("firstName")) {
			regexQuery.put("firstName", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		else if(inputParam.equalsIgnoreCase("lastName")) {
			regexQuery.put("lastName", new BasicDBObject("$regex", inputValue).append("$options", "i"));
		}
		
		//return  fetchRootCollection().find(Filters.eq("phoneNo", inputValue), RootMDB.class).first();
		return fetchRootListCollection().find(regexQuery).first();
	}
	
	
	public RootMDB validateUserDetails(String userName, String password){
		return fetchRootCollection().find(Filters.eq("phoneNo", userName), RootMDB.class).first();
	}
	
	/***
	 * 	This method is used to fetch Root Collection
	 * @return RootCollection
	 */	
	public MongoCollection<RitvikMDB> fetchRitvikCollection(){
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.RITVIK_COLLECTION,RitvikMDB.class);	
	}

	

	public MongoCollection<SatsangeeMDB> fetchSatsangeeCollection() {
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.SATSANGEE_COLLECTION,SatsangeeMDB.class);	
	}
	/***
	 * 	This method is used to fetch Root Collection
	 * @return RootCollection
	 */	
	public MongoCollection<RootMDB> fetchRootCollection(){
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ROOT_COLLECTION,RootMDB.class);	
	}
	
	/**
	 * seq id for Isht receipt no
	 * @param sequenceName
	 * @return
	 */
	public BigDecimal getIshtSequenceIdForSeqName(String sequenceName)  {
		IshtSequence seqObj = fetchIshtSequenceCollection().findOneAndUpdate(Filters.eq(MongoConstants.MONGO_ID, sequenceName),
				Updates.inc(MongoConstants.SEQ_VALUE, 1),
				new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true));

		if (seqObj == null || seqObj.getSeqValue() == null) {
			
		}

		return seqObj.getSeqValue();
	}

	public MongoCollection<IshtSequence> fetchIshtSequenceCollection() {
		return getMongoClient().getDatabase(getMongoDbName()).getCollection(MongoConstants.ISHT_SEQ, IshtSequence.class);
	}

	
 public List<IshtLineMDB> fetchIshtLines(final String familyId) {

//            if (familyId != null) {
//		                final Document doc = this.getMongoClient().getDatabase(this.getMongoDbName())
//		                        .getCollection(OnlineSAConstants.ISHT_COLLECTION, IshtMDB.class)
//		                        .find(eq("familyID", familyId), Document.class)
//		                        .projection(include("line")).sort(Sorts.descending("_id")).first();
//		                if (doc != null) {
//		                    final List<IshtLineMDB> lines = com.olsa.utility.MongoUtil.documentListToObjectList((List<Document>) doc
//		                            .get("line"), IshtLineMDB.class);
//		                        return lines;
//		                    }
//		                else  {
//		                   	 logger.info("Inside Else condition there is no transaction lines.");
//		                	return null;
//		                }
//
//		                }
		            return null;
       }
 
 protected Date fetchLatestIshtDate(String familyId) {

     if (familyId != null) {
	                final Document doc = this.getMongoClient().getDatabase(this.getMongoDbName())
	                        .getCollection(OnlineSAConstants.ISHT_COLLECTION, IshtMDB.class)
	                        .find(eq("familyID", familyId), Document.class)
	                        .projection(include("submittedOn")).sort(Sorts.descending("_id")).first();
	                if (doc != null) {
	                		System.out.println((Date)doc.get("submittedOn"));
	                        return (Date)doc.get("submittedOn");
	                    }
	                else  {
	                	return null;
	                }
	                
	                }
	            return null;
	}

}
