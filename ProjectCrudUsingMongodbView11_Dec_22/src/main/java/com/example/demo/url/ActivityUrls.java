package com.example.demo.url;

public class ActivityUrls {
	private static final String PROJECT_PREFIX = "/project";
	private static final String CONTACT_PREFIX = "/contact";
	private static final String USERFILE_PREFIX = "/user";
	private static final String ACTIVITY_PREFIX = "/activity";



	public static class PathVars {

		public static final String CONTACT_ID = GlobalConstants.CONTACT_ID;

	}

	public static class RequestParams {

		public static final String CONTACT_ID = GlobalConstants.CONTACT_ID;
	}

	/**
	 * Version 1 (original) API URLs
	 */
	public static class V1 {

		/**
		 * Http.GET request URLs
		 */
		public static class Get {
			public static final String CONTACT_BY_ID = CONTACT_PREFIX + "/getById/{" + PathVars.CONTACT_ID + "}";
			public static final String GET_ALL_CONTACT = CONTACT_PREFIX + "/getAll";
			public static final String GET_USER_FILES = USERFILE_PREFIX + "/load/files";
            public  static final String GET_ALL_USER_FILES = USERFILE_PREFIX +"/load/all/files";

		}

		/*
		 * Http.POST request URLs
		 */
		public static class Post {
			public static final String CREATE_CONTACT = CONTACT_PREFIX + "/create";
			public static final String COPY_CONTACT = CONTACT_PREFIX + "/{" + PathVars.CONTACT_ID + "}/copy";
            public  static final String ADD_UPDATE_USERFILES = USERFILE_PREFIX +"/add/update/files";
            public  static final String ADD_UPDATE_SINGLE_USERFILE = USERFILE_PREFIX +"/add/update/single/file";
            public  static final String ACTIVITY_CREATE = ACTIVITY_PREFIX +"/create";
		}
		/*
		 * Http.DELETE request URLs
		 */
		public static class Delete {
			public static final String DELETE_CONTACT = CONTACT_PREFIX + "/{" + PathVars.CONTACT_ID + "}/delete";
			public static final String DELETE_USER_FILES = USERFILE_PREFIX + "/files/remove";

		}
		/*
		 * Http.PUT request URLs
		 */
		public static class Put {
			public static final String UPDATE_CONTACT = CONTACT_PREFIX + "/update";
		}
	}

}
