package com.bettrhuman.service.models;

import lombok.Data;

@Data
public class CloudFile {
	String filename;
	String bucket;
	boolean publicallyAccessible;
}
