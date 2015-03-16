package io.ganguo.app.gcache.transcoder;

import io.ganguo.app.gcache.interfaces.Cache.Entry;
import io.ganguo.app.gcache.interfaces.Transcoder;

public class StringTranscoder implements Transcoder<String, String> {

	@Override
	public Entry encode(String value, int ttl) {
		return new Entry(value.getBytes(), ttl);
	}

	@Override
	public String decode(Entry entry) {
		return new String(entry.getData());
	}

	@Override
	public String decodeKey(String key) {
		return key;
	}

}
