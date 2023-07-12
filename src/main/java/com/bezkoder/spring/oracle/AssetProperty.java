package com.bezkoder.spring.oracle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetProperty {

    String key;
    String value;
}
