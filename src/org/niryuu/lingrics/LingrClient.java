package org.niryuu.lingrics;

import com.loopj.android.http.*;

public class LingrClient {
	private static final String BASE_URL = "http://lingr.com/api/";
	private static AsyncHttpClient client = new AsyncHttpClient();
	private static AsyncHttpClient observeClient = new AsyncHttpClient();

	public LingrClient() {
		observeClient.setTimeout(2147483647);
	}

	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void observe(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		observeClient.cancelRequests(null, true);
		observeClient.get(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
