package com.bettrhuman.service.utilities;

/**
 * Contains the client IDs and scopes for allowed clients consuming your API.
 */
public class Constants
{
  public static final String WEB_CLIENT_ID =
      "replace this with the Webclient Id";
  public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
  public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
  public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

  public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";

  public static final String UNAUTHENTICATED = "User is Not Valid";
  public static final String UNAUTHORIZED = "Unauthorized action";
}
