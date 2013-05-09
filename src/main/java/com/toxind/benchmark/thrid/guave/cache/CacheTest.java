package com.toxind.benchmark.thrid.guave.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.ImmutableMap;

public class CacheTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ExecutionException {
		LoadingCache<String, Date> graphs = CacheBuilder.newBuilder().maximumSize(10)
				.expireAfterWrite(60, TimeUnit.SECONDS)
				.removalListener(new DateRemovalListener())
				.build(new CacheLoader<String, Date>() {
					public Date load(String key) throws IOException {
						return new Date();
					}
				});

		try {
			for(int i = 0 ; i < 15 ; i ++){
				
				System.out.println(graphs.get("a1") + " .. ");
				Thread.sleep(1);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		List<String> listStr = new ArrayList<String>();
		listStr.add("a");
		
		ImmutableMap<String, Date> x = graphs.getAll((Iterable<? extends String>) listStr.iterator());
		System.out.println(Arrays.toString(x.keySet().toArray()));
		System.out.println(Arrays.toString(x.values().toArray()));

	}

}

class DateRemovalListener implements RemovalListener{

	@Override
	public void onRemoval(RemovalNotification notification) {
		
		System.out.println("xxxxxxxxxxxxxxxxxxx");
		
	}
	
}
