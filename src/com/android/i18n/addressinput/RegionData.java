/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.i18n.addressinput;

/**
 * A simple class to hold region data. Instances of this class are immutable.
 */
public class RegionData {
  private String key;
  private String name;

  /**
   * Create a new RegionData object.
   */
  private RegionData() {}

  /**
   * Copy constructor. data should not be null.
   *
   * @param data A populated instance of RegionData
   */
  private RegionData(RegionData data) {
    Util.checkNotNull(data);
    this.key = data.key;
    this.name = data.name;
  }

  /**
   * Gets the key of the region. For example, California's key is "CA".
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the name. Returns null if not specified.
   */
  public String getName() {
    return name;
  }

  /**
   * Checks if the input subkey is the name (in Latin or local script) of the
   * region. Returns false if subkey is not a valid name for the region, or
   * the input subkey is null.
   *
   * @param subkey a string that refers to the name of a geo location. Like "California",
   *      "CA", or "Mountain View". Names in the local script are also supported.
   */
  public boolean isValidName(String subkey) {
    if (subkey == null) {
      return false;
    }
    if (subkey.equalsIgnoreCase(key) || subkey.equalsIgnoreCase(name)) {
      return true;
    }
    return false;
  }

  /**
   * A builder class to facilitate the creation of RegionData objects.
   */
  public static class Builder {
    RegionData data = new RegionData();

    public RegionData build() {
      return new RegionData(data);
    }

    public Builder setKey(String key) {
      Util.checkNotNull(key, "Key should not be null.");
      data.key = key;
      return this;
    }

    /**
     * Sets name of the region. For example, "California".
     */
    public Builder setName(String name) {
      data.name = name;
      return this;
    }
  }
}