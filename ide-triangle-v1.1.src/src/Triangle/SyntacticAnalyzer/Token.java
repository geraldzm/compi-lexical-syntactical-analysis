/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;      
      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }
  public static String toKind(Token lol) {
    return tokenTable[lol.kind];
  }
  
  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    CASE                = 5,
    CONST		= 6,
    DO			= 7,
    ELIF		= 8,  
    ELSE		= 9,
    END			= 10,
    FOR                 = 11, //Agregamos FOR Stephanie Quiros
    FROM                = 12, //Agregamos FROM Stephanie Quiros
    FUNC		= 13,
    IF			= 14,
    IN			= 15,
    LEAVE		= 16, //Agregamos LEAVE Gerald
    LET			= 17,
    NOTHING		= 18, // Agregamos NOTHING   Leonardo Farina
    OF			= 19,
    PRIVATE             = 20, // Agregamos PRIVATE   David Suarez
    PROC		= 21,
    RECORD		= 22,
    RECURSIVE           = 23, // Agregamos RECURSIVE David Suarez
    REPEAT              = 24, //Agregamos REPEAT Stephanie Quiros
    THEN		= 25,
    TYPE		= 26,
    UNTIL               = 27, //Agregamos UNTIL Stephanie Quiros
    VAR			= 28,
    WHEN                = 29,
    WHILE		= 30,
  
    // punctuation...
    DOT			= 31,
    COLON		= 32,
    SEMICOLON           = 33,
    COMMA		= 34,
    BECOMES		= 35,
    IS			= 36,
    DOUBLEDOT           = 37, //Agregamos DOUBLEDOT Stephanie Quiros

    // brackets...
    LPAREN		= 38,
    RPAREN		= 39,
    LBRACKET            = 40,
    RBRACKET            = 41,
    LCURLY		= 42,
    RCURLY		= 43,

    // special tokens...
    EOT			= 44,
    ERROR		= 45;
          

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "case",
    "const",
    "do",
    "elif", // Cambio Gerald Zamora
    "else",
    "end",
    "for", //Agregamos for Stephanie Quiros
    "from", //Agregamos from Stephanie Quiros
    "func",
    "if",
    "in",
    "leave",
    "let",
    "nothing", // Cambio Leonardo Farina agragamos "nothing"
    "of",
    "private", // Cambio David Suarez agragamos "private"
    "proc",
    "record",
    "recursive", // Cambio David Suarez agragamos "recursive"
    "repeat", //Agregamos repeat Stephanie Quiros
    "then",
    "type",
    "until", //Agregamos until Stephanie Quiros
    "var",
    "when",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "..", //Agregamos .. Stephanie Quiros
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"    
  };

  private final static int	firstReservedWord = Token.ARRAY,                                
  				lastReservedWord  = Token.WHILE; 

}
