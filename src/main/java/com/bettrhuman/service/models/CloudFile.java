package com.bettrhuman.service.models;

import lombok.Data;

@Data
public class CloudFile {
	private String filename;
	private String bucket;
	private boolean publicallyAccessible;
}
