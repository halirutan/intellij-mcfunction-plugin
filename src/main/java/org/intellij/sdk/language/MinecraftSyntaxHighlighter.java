package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.MinecraftTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author Soni
 */

public class MinecraftSyntaxHighlighter extends SyntaxHighlighterBase
{
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("MINECRAFT_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("MINECRAFT_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE = createTextAttributesKey("MINECRAFT_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("MINECRAFT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("MINECRAFT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    
    
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    
    @NotNull
    @Override
    public Lexer getHighlightingLexer()
    {
        return new MinecraftLexerAdapter();
    }
    
    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
    {
        if (tokenType.equals(MinecraftTypes.SEPARATOR))
        {
            return SEPARATOR_KEYS;
        }
        else if (tokenType.equals(MinecraftTypes.KEY))
        {
            return KEY_KEYS;
        }
        else if (tokenType.equals(MinecraftTypes.VALUE))
        {
            return VALUE_KEYS;
        }
        else if (tokenType.equals(MinecraftTypes.COMMENT))
        {
            return COMMENT_KEYS;
        }
        else if (tokenType.equals(TokenType.BAD_CHARACTER))
        {
            return BAD_CHAR_KEYS;
        }
        else
        {
            return EMPTY_KEYS;
        }
    }
}