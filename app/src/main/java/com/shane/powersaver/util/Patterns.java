package com.shane.powersaver.util;

import java.util.regex.Pattern;

/**
 * provide WEB_URL link pattern.
 *
 * @hide
 */
public class Patterns {

    public static final String TOP_LEVEL_DOMAIN_STR_FOR_WEB_URL = android.util.Patterns.TOP_LEVEL_DOMAIN_STR_FOR_WEB_URL;

    /**
     * Good characters for Internationalized Resource Identifiers (IRI). This
     * comprises most common used Unicode characters allowed in IRI as detailed
     * in RFC 3987. Specifically, Unicode characters are removed.
     */
    public static final String GOOD_IRI_CHAR =
            "a-zA-Z0-9";

    /**
     * Regular expression pattern to match most part of RFC 3987
     * Internationalized URLs, aka IRIs. Commonly used Unicode characters are
     * added.
     */
    public static final Pattern WEB_URL = Pattern
            .compile(
            "((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)"
                    + "\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_"
                    + "\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?"
                    + "((?:(?:[" + GOOD_IRI_CHAR + "][" + GOOD_IRI_CHAR
                    + "\\-]{0,64}\\.)+" // named host
                    + TOP_LEVEL_DOMAIN_STR_FOR_WEB_URL
                    + "|(?:(?:25[0-5]|2[0-4]" // or ip address
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]"
                    + "|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9])))"
                    + "(?:\\:\\d{1,5})?)" // plus option port number
                    + "(\\/(?:(?:[" + GOOD_IRI_CHAR
                    + "\\;\\/\\?\\:\\@\\&\\=\\#\\~" // plus option query params
                    + "\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?"
                    + "(?=\\b|[^\u0000-\u00ff]|$)"); // and finally, a word
                                                     // boundary or end of
                                                     // input. This is to stop
                                                     // foo.sure from
                                                     // matching as foo.su

    /**
     * Transform matched time strings into something suitable to be added to calendar.
     * For instance: 2014年3月12日, 2014/3/12, 3/12/2014, 3月8日 15时, 2014.3.12 15:28, 3-28到5-1, 明年4月, 明天早上8点, etc.
     */
    public static final String ENGLISH_TIME_PATTERN_STRING = "(((((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM]))(\\s+,?|(,\\s*))(((((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))(\\s+,?|(,\\s*))\\d{4})|(((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))|(((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9]))|(((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9]))|((\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))))|((((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM]))(\\s+(,|([Oo][Nn]\\s+))?|(,\\s*))(\\b(([Mm][Oo][Nn]|[Tt][Uu][Ee][Ss]|[Tt][Hh][Uu][Rr]|[Ff][Rr][Ii]|[Ss][Uu][Nn])((\\.)|([Dd][Aa][Yy]))?|[Ww][Ee][Dd]((\\.)|([Nn][Ee][Ss][Dd][Aa][Yy]))?|[Ss][Aa][Tt]((\\.)|([Uu][Rr][Dd][Aa][Yy]))?)))|(((((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))))(\\s+,?|(,\\s*))\\d{4})|(((\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?))\\s+(1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3]))|((1([sS][tT])|2([nN][dD])|3([rR][dD])|((3[01]|[12][0-9]|0?[4-9])([tT][hH])?)|[1-3])\\s+(\\b([Jj](([Aa][Nn]((\\.)|([Uu][Aa][Rr][Yy]))?)|([Uu](([Nn]((\\.)|[Ee])?)|([Ll]((\\.)|[Yy])?))))|[Ff][Ee][Bb]((\\.)|([Rr][Uu][Aa][Rr][Yy]))?|[Mm][Aa](([Rr]((\\.)|([Cc][Hh]))?)|([Yy](\\.)?))|[Aa](([Pp][Rr]((\\.)|([Ii][Ll]))?)|([Uu][Gg]((\\.)|([Uu][Ss][Tt]))?))|([Ss][Ee][Pp][Tt]|[Nn][Oo][Vv]|[Dd][Ee][Cc])((\\.)|([Ee][Mm][Bb][Ee][Rr]))?|[Oo][Cc][Tt]((\\.)|([Oo][Bb][Ee][Rr]))?)))))|(((2[0-4]|(1|0?)[0-9]):([1-5][0-9]|0?[0-9])(:([1-5][0-9]|0?[0-9]))?([aApP][mM])?)|(2[0-4]|(1|0?)[0-9])([aApP][mM])))";
    public static final String CHINESE_TIME_PATTERN_STRING = "(((([周週]|(星期))[一二三四五六日天])(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(((今|明|大?后)天|次日)(凌晨|上午|下午|早上|晚上|傍晚|中午))|(((((((\\d{4}|[零一二三四五六七八九]{4}|(今|明|大?[后後]))年))?((1[012]|0?[1-9]|十[一二]?|[一二三四五六七八九])月))?|((本|下[个個]?|这个|這個)月))((3[01]|[12][0-9]|0?[1-9]|三十一?|(二?十)[一二三四五六七八九]?|[一二三四五六七八九])(日|号|號)))(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(凌晨|上午|下午|早上|晚上|傍晚|中午)|((今|明|大?后)天|次日))?(2[0-4]|(1|0?)[0-9]|二十[一二三四]?|十?[一二三四五六七八九两兩]|零|十)(((时|点|時|點|[Pp][Mm])(([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(分(([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])秒)?)?)?)|(:([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(:([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩]))?))|((([周週]|(星期))[一二三四五六日天])(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|(((今|明|大?后)天|次日)(凌晨|上午|下午|早上|晚上|傍晚|中午))|(((((((\\d{4}|[零一二三四五六七八九]{4}|(今|明|大?[后後]))年))?((1[012]|0?[1-9]|十[一二]?|[一二三四五六七八九])月))?|((本|下[个個]?|这个|這個)月))((3[01]|[12][0-9]|0?[1-9]|三十一?|(二?十)[一二三四五六七八九]?|[一二三四五六七八九])(日|号|號)))(凌晨|上午|下午|早上|晚上|傍晚|中午)?)|((((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])|((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])|(\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))((凌晨|上午|下午|早上|晚上|傍晚|中午)|(\\s)+)((2[0-4]|(1|0?)[0-9]|二十[一二三四]?|十?[一二三四五六七八九两兩]|零|十)(((时|点|時|點|[Pp][Mm])(([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(分(([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])秒)?)?)?)|(:([123一二三两]刻|半|[1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩])(:([1-5][0-9]|0?[0-9]|[二三四五]?十[一二三四五六七八九]?|零|十|[一二三四五六七八九两兩]))?))))|((((\\d{4})-)?(1[012]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])|((\\d{4})/)?(1[012]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])|(\\d{4})\\.(1[012]|0?[1-9])\\.(3[01]|[12][0-9]|0?[1-9]))((凌晨|上午|下午|早上|晚上|傍晚|中午))?)";
    public static final String TO_PATTERN_STRING = "((\\s+[tT][oO]\\s+)|(\\s*[-到至]\\s*))";
    public static final Pattern CHINESE_TIME_PATTERN = Pattern.compile(
            "("
            + "("
            + CHINESE_TIME_PATTERN_STRING + ")"
                    + "(" + TO_PATTERN_STRING
            + "(" + CHINESE_TIME_PATTERN_STRING + "))?"
                    + ")");
    public static final Pattern ENGLISH_TIME_PATTERN = Pattern.compile(
            "("
            + "("
            + ENGLISH_TIME_PATTERN_STRING + ")"
            + "(" + TO_PATTERN_STRING + "(" + ENGLISH_TIME_PATTERN_STRING + "))?"
            + ")"
            );
}
