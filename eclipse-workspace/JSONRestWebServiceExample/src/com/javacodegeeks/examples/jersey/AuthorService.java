package com.javacodegeeks.examples.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

@Path("/AuthorService")
public class AuthorService { 
	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> getTrackInJSON() {
		List<Result> resList = new ArrayList<>();
		Result r1 = new Result("0030K00001TNVf5QAH", "Tuðçe", "Þirin", "tugce.sirin@inspark.com", "5584525855", "type",
				"asasdasdasasd", true);
		Result r2 = new Result("0030K00001TNVf5QAH", "Mertcan", "Boða", "mert.boga@inspark.com", "5584525855", "type",
				"asasdasdasasd", true);

		resList.add(r1);
		resList.add(r2);
		return resList;
	}

	@GET
	@Path("/encryption")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> encryption(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("eMail") String eMail, @QueryParam("phone") String phone,
			@QueryParam("encryption") boolean encryption) {
		try {

	        String key = "Bar12345Bar12345"; // 128 bit key
	        String initVector = "RandomInitVector"; // 16 bytes IV
		 
			if (encryption) {
			 
				firstName = AESAlgorithm.encrypt(key, initVector, firstName);
				lastName = AESAlgorithm.encrypt(key, initVector, lastName);
				phone = AESAlgorithm.encrypt(key, initVector, phone);
				eMail = AESAlgorithm.encrypt(key, initVector, eMail); 
				 
			} else {

				firstName = AESAlgorithm.decrypt(key, initVector, firstName);
				lastName = AESAlgorithm.decrypt(key, initVector, lastName);
				phone = AESAlgorithm.decrypt(key, initVector, phone);
				eMail = AESAlgorithm.decrypt(key, initVector, eMail);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Result> resList = new ArrayList<>();
		Result r1 = new Result("0030K00001TNVf5QAH", firstName, lastName, phone, eMail, "type", "asasdasdasasd",
				encryption);
		Result r2 = new Result("0030K00001TNVf5QAH", "Mertcan", "Boða", "5584525855", "mert.boga@inspark.com", "type",
				"asasdasdasasd", encryption);

		resList.add(r1);
		resList.add(r2);

		return resList;
	} 
}
