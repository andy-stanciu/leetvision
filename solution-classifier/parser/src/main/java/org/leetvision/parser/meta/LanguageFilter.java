package org.leetvision.parser.meta;

import org.leetvision.parser.Language;

public record LanguageFilter(Language... languages) {
    public int getMask() {
        int mask = 0;
        if (languages != null) {
            for (var language : languages) {
                mask |= 1 << language.ordinal();
            }
        }
        return mask;
    }

    public static LanguageFilter NONE = new LanguageFilter();
    public static LanguageFilter ALL = new LanguageFilter(Language.values());
}
