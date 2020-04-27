package com.epsilon.jive;

import com.epsilon.jive.models.JiveContentWrapper;

public interface ObjectConverter {

    JiveContentWrapper createJivePlace(String responseJson);
}
