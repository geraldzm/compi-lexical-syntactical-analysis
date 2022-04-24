/*
 * @(#)Scanner.java                        2.1 2003/10/07
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

import Triangle.GenerateHTML;


public final class Scanner {

   // Leonardo
  public GenerateHTML cs;
  private Integer checkHTML;  
  private String completeHTML = "";  
  
  private SourceFile sourceFile;
  private boolean debug;

  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////

  public Scanner(SourceFile source) {
    sourceFile = source;
    currentChar = sourceFile.getSource();
    debug = false;
  }

  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.

  private void takeIt() {
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();
  }

  // scanSeparator skips a single separator.

  private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        completeHTML += "<b style=\"color:#5EFE68; font-weight: normal;\">" + currentChar;  
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT)){
          takeIt();
          completeHTML += currentChar;
        }
        if (currentChar == SourceFile.EOL)
            completeHTML += "<br>";  
          takeIt();
      }
      break;

    case ' ': {
        completeHTML += "&nbsp;";
      takeIt();
      break;
    }
    
    case '\n':{
      completeHTML += "<br>";  
      takeIt();
      break;
    }
    
    case '\r': {    
      takeIt();
      break;
    }
    
    case '\t':{
      completeHTML += "&ensp;";
      takeIt();
      break;
    }
    }
  }

  private int scanToken() {

    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar))
        takeIt();
      
      return Token.IDENTIFIER;

    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
      return Token.INTLITERAL;

    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      while (isOperator(currentChar))
        takeIt();
      return Token.OPERATOR;

    case '\'':
      takeIt();
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        return Token.CHARLITERAL;
      } else
        return Token.ERROR;

    case '.':
      takeIt();
      return Token.DOT;

    case ':':
      takeIt();
      if (currentChar == '=') {
        takeIt();
        return Token.BECOMES;
      } else
        return Token.COLON;

    case ';':
      takeIt();
      return Token.SEMICOLON;

    case ',':
      takeIt();
      return Token.COMMA;

    case '~':
      takeIt();
      return Token.IS;

    case '(':
      takeIt();
      return Token.LPAREN;

    case ')':
      takeIt();
      return Token.RPAREN;

    case '[':
      takeIt();
      return Token.LBRACKET;

    case ']':
      takeIt();
      return Token.RBRACKET;

    case '{':
      takeIt();
      return Token.LCURLY;

    case '}':
      takeIt();
      return Token.RCURLY;

    case SourceFile.EOT:
      return Token.EOT;

    default:
      takeIt();
      return Token.ERROR;
    }
  }

  public Token scan () {
    // Leonardo 
    
    if (checkHTML == null){
        checkHTML = 1;
        completeHTML += "<!DOCTYPE html>\n" +
"                        <html lang=\"es\">\n" +
"                        <head>\n" +
"                          <meta charset=\"utf-8\">\n" +
"                          <title>Proyecto 1</title>\n" +
"                        </head>                        \n" +
"                        <style>\n" +
"                           p {\n" +
"                               font-size: 1em;\n" +
"                               font-family: \"Roboto\", monospaced;\n" +
"                           }\n" +
"                        </style>\n" +
"                        <body>\n" +
"                        ";
        completeHTML +="<p>";
       // prin();  
    }
    
    
    Token tok;
    SourcePosition pos;
    int kind;

    currentlyScanningToken = false;
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();

    kind = scanToken();

    pos.finish = sourceFile.getCurrentLine();
    
    tok = new Token(kind, currentSpelling.toString(), pos);
    
    if (debug)
      System.out.println(tok);
    // Leonardo
    addHTML(tok.kind,tok.spelling);
    return tok;
  }
 
    // Leonardo
   public void addHTML(Integer typeTok, String name) {
    
    if (typeTok < 2 ){
        completeHTML += "<b style=\"color:#0013B8; font-weight: normal;\">"+name;
    }
    else if (typeTok <= 21 && typeTok >= 4){
        completeHTML += "<b style=\"color:black; font-weight: bold;\">"+name;
    }
    else{
        completeHTML += "<b style=\"color:black; font-weight: normal;\">"+name;
    }
    
    if(34 == typeTok){
        completeHTML +="</p>"
                + "                        </body>\n" 
                + "                        </html>";
        prin();
    }
  }
   
  // Leonardo
   public void prin() {
    cs = new GenerateHTML(completeHTML);
  }

}
