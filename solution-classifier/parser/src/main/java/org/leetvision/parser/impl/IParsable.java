package org.leetvision.parser.impl;

public interface IParsable {
    boolean parse(String fileName);
    Language getLanguage();
}
