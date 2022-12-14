package com.example.demo.url;

public class ActivityUrls {
	private static final String PROJECT_PREFIX = "/project";
	private static final String CONTACT_PREFIX = "/contact";
	private static final String USERFILE_PREFIX = "/user";


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
		}

		/*
		 * Http.POST request URLs
		 */
		public static class Post {
			public static final String CREATE_CONTACT = CONTACT_PREFIX + "/create";
			public static final String COPY_CONTACT = CONTACT_PREFIX + "/{" + PathVars.CONTACT_ID + "}/copy";
            public  static final String ADD_UPDATE_USERFILES = USERFILE_PREFIX +"/add/update/files";
		}

		public static class Delete {
			public static final String DELETE_CONTACT = CONTACT_PREFIX + "/{" + PathVars.CONTACT_ID + "}/delete";
		}

		public static class Put {
			public static final String UPDATE_CONTACT = CONTACT_PREFIX + "/update";
		}
	}

}
