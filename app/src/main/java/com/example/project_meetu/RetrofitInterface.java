package com.example.project_meetu;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface RetrofitInterface {

    /**
     * Login HTTP protocol for calling information from Login
     * @param map: input of Wisconsin Student ID
     * @return returned student information
     */
    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    /**
     * Signup HTTP protocol for transporting information to Sql Database
     * @param map: input of student information
     * @return Check validity
     */
    @POST("/signup")
    Call<Void> executeSignup (@Body HashMap<String, String> map);

    /**
     * Generate HTTP protocol for Mapped student lists from Sql Database
     * @param map: input of each equal category
     * @return other student information from mapped list
     */
    @POST("/generate")
    Call<List<String>> executeGenerate (@Body HashMap<String, String> map);


    /**
     * Find HTTP protocol for Find student information for Wisconsin Student ID
     * @param map: input Wisconsin Student ID
     * @return student having inputted ID from Sql Database
     */
    @POST("/find")
    Call<Student> executeFind (@Body HashMap<String, String> map);



}