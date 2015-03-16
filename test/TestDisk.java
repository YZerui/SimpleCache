import io.ganguo.app.gcache.CacheBuilder;
import io.ganguo.app.gcache.Config;
import io.ganguo.app.gcache.interfaces.GCache;
import io.ganguo.app.gcache.transcoder.StringTranscoder;
import io.ganguo.app.gcache.util.GBenchmark;

import java.io.File;

public class TestDisk {
	private static final String TAG = TestDisk.class.getName();

	public static void main(String[] args) {
		GCache cache = CacheBuilder.newBuilderForDisk()
				.withTranscoder(new StringTranscoder())
				.withCacheRootDirectory(new File("diskCache"))
				.maxDiskUsageBytes(5 * Config.BYTES_MB)
				.defaultCacheTime(5000)
				.build();
		
		testPut(cache, 10);
		testGet(cache, 10);
	}

	public static void testPut(GCache cache, int count) {
		GBenchmark.start("testPut" + count);
		for (int i = 0; i < count; i++) {
			cache.put(i + "", i + TAG);
		}
		GBenchmark.end("testPut" + count);
	}

	public static void testGet(GCache cache, int count) {
		GBenchmark.start("testGet" + count);
		for (int i = 0; i < count; i++) {
			System.out.println(cache.get(i + ""));
		}
		GBenchmark.end("testGet" + count);
	}
}
