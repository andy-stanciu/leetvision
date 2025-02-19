package org.leetvision.parser;

import org.leetvision.parser.meta.LanguageFilter;

public enum Language {
    CPP,
    JAVA,
    JAVASCRIPT,
    TYPESCRIPT,
    C,
    GOLANG,
    PYTHON,
    CSHARP,
    UNKNOWN;

    public boolean withinFilter(LanguageFilter filter) {
        int selfMask = 1 << ordinal();
        return (filter.getMask() & selfMask) == selfMask;
    }
}
