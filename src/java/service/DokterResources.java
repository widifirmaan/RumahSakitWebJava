/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.DokterHelper;
import helper.PasienHelper;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Dokter;

/**
 *
 * @author MR98X
 */
@Path("Dokter")
public class DokterResources {

    @Context
    private UriInfo context;
    
    public DokterResources() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {        
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("getDokter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDokter() {
        DokterHelper helper = new DokterHelper();
        List<Dokter> list = helper.getDokter();
        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(list))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }

    @POST
    @Path("addDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data) {
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data, Dokter.class);
        DokterHelper helper = new DokterHelper();
        helper.addNewDokter(dokter.getId(),
                dokter.getNama(),
                dokter.getSpesialis());

        return Response
                .status(200)
                .entity(dokter)
                .build();
    }
}
