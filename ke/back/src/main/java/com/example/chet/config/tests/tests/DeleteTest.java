package com.example.chet.config.t3.tests;// Generated by Selenium IDE
import com.example.chet.config.t3.TestBasClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class DeleteTest extends TestBasClass {

  @Test
  public void delete() {
//    appMan.getNavHelp().OpenMainPage();
//    appMan.getAuthHelp().EnterLoginAndPassword();
    appMan.getChangeHelp().DeleteRep();
    appMan.getNavHelp().OpenMainPage();
  }
}