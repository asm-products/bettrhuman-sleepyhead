package com.bettrhuman.service.utilities;

import com.bettrhuman.service.exceptions.CloudStorageException;
import com.bettrhuman.service.models.CloudFile;

public interface ICloudStorage
{

  public void storeFile(CloudFile file, byte[] fileBytes) throws CloudStorageException;
}
