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
    CONST		= 5,
    DO			= 6,
    ELIF		= 7,  
    ELSE		= 8,
    END			= 9,
    FUNC		= 10,
    FOR                 = 11, //Agregamos FOR Stephanie Quiros
    FROM                = 12, //Agregamos FROM Stephanie Quiros
    IF			= 13,
    IN			= 14,
    LEAVE		= 15, //Agregamos LEAVE Gerald
    LET			= 16,
    NOTHING		= 17, // Agregamos NOTHING   Leonardo Farina
    OF			= 18,
    PROC		= 19,
    RECORD		= 20,
    REPEAT              = 21, //Agregamos REPEAT Stephanie Quiros
    THEN		= 22,
    TYPE		= 23,
    UNTIL               = 24, //Agregamos UNTIL Stephanie Quiros
    VAR			= 25,
    WHILE		= 26,

      
  
    // punctuation...
    DOT			= 27,
    COLON		= 28,
    SEMICOLON           = 29,
    COMMA		= 30,
    BECOMES		= 31,
    IS			= 32,
    DOUBLEDOT           = 33, //Agregamos DOUBLEDOT Stephanie Quiros

    // brackets...
    LPAREN		= 34,
    RPAREN		= 35,
    LBRACKET            = 36,
    RBRACKET            = 37,
    LCURLY		= 38,
    RCURLY		= 39,

    // special tokens...
    EOT			= 40,
    ERROR		= 41;
          

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "const",
    "do",
    "elif", // Cambio Gerald Zamora
    "else",
    "end",
    "func",
    "for", //Agregamos for Stephanie Quiros
    "from", //Agregamos from Stephanie Quiros
    "if",
    "in",
    "leave",
    "let",
    "nothing", // Cambio Leonardo Farina agragamos "nothing"
    "of",
    "proc",
    "record",
    "repeat", //Agregamos repeat Stephanie Quiros
    "then",
    "type",
    "until", //Agregamos until Stephanie Quiros
    "var",
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
