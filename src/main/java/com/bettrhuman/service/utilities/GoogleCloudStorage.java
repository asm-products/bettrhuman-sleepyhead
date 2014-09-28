package com.bettrhuman.service.utilities;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import lombok.AllArgsConstructor;

import com.bettrhuman.service.exceptions.CloudStorageException;
import com.bettrhuman.service.models.CloudFile;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class GoogleCloudStorage implements ICloudStorage
{
  private static final Logger log = Logger.getLogger(GoogleCloudStorage.class
      .getName());

  GcsService gcsService;

  @Override
  public void storeFile(CloudFile file, byte[] fileBytes) throws CloudStorageException
  {
    try
    {
      GcsFilename filename = new GcsFilename(file.getBucket(),
          file.getFilename());

      GcsOutputChannel outputChannel;
      if (file.isPublicallyAccessible())
      {
        outputChannel = gcsService
            .createOrReplace(filename,
                new GcsFileOptions.Builder()
                    .mimeType("text/plain")
                    .acl("public-read")
                    .build());
      }
      else
      {
        outputChannel = gcsService
            .createOrReplace(filename,
                new GcsFileOptions.Builder()
                    .mimeType("text/plain")
                    .build());
      }

      outputChannel.write(ByteBuffer.wrap(fileBytes));
      outputChannel.close();
    }
    catch (IOException e)
    {
      log.log(Level.SEVERE, "Error creating file in bucket", e);
      throw new CloudStorageException(file, e);
    }
  }
}
