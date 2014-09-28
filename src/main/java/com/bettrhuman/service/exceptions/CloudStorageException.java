package com.bettrhuman.service.exceptions;

import java.io.IOException;

import com.bettrhuman.service.models.CloudFile;

public class CloudStorageException extends Exception {

	private static final long serialVersionUID = -6977488326792523368L;

	public CloudStorageException(CloudFile file, IOException e) {
		super(e);
	}

}
