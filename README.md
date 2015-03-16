SimpleCache
======

轻量级的缓存框架，可在Android和Java项目中用于频繁数据的缓存，以下为示例：

======

DiskWithMemoryCache:

	GCache cache = Builders.newBuilder()
				.withTranscoder(new StringTranscoder())
				.withCacheRootDirectory(new File("diskCache"))
				.maxDiskUsageBytes(10000)
				.maxMemoryUsageBytes(1000)
				.defaultCacheTime(50)
				.build();
				
MemoryCache:

	GCache cache = Builders.newBuilderForMemory()
				.withTranscoder(new StringTranscoder())
				.maxMemoryUsageBytes(10000)
				.defaultCacheTime(20)
				.build();
				
DiskBasedCache:

	GCache cache = Builders.newBuilderForDisk()
				.withTranscoder(new StringTranscoder())
				.withCacheRootDirectory(new File("diskCache"))
				.maxDiskUsageBytes(1000)
				.defaultCacheTime(50)
				.build();			
				

	cache.put(K, V); //use defaultCacheTime
	cache.put(K, V, TTL);
	cache.get(K);
