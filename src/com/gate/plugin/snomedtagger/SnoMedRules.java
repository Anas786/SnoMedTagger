/* SnoMedTagger : SNOMED CT Medical Tagger
 *  Developed by Hafiz Muhammad Anas, Contact : anas_abdani@hotmail.com Or hanas@knysys.com
 *  Developed by Saman Hina, Contact : saman.hina@gmail.com Or scsh@leeds.ac.uk
 *  -----------------------------------------------------------------------------------
 *  Copyright (c) 2012-2013, The University of Leeds.
 *  This application is developed as part of GATE (see http://gate.ac.uk/), and is free
 *  for research purposes 
 *  Saman Hina, 18-04-2012
 *  -----------------------------------------------------------------------------------
 *  SnoMedRules.java
 *
 * Copyright (c) 2000-2012, The University of Sheffield.
 *
 * This file is part of GATE (see http://gate.ac.uk/), and is free
 * software, licenced under the GNU Library General Public License,
 * Version 3, 29 June 2007.
 *
 * A copy of this licence is included in the distribution in the file
 * licence.html, and is also available at http://gate.ac.uk/gate/licence.html.
 *
 *  anas__000, 13/11/2016
 *
 * For details on the configuration options, see the user guide:
 * http://gate.ac.uk/cgi-bin/userguide/sec:creole-model:config
 */


package com.gate.plugin.snomedtagger;

import gate.creole.Transducer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;
import gate.creole.metadata.HiddenCreoleParameter;
import java.net.URL;

/**
 * This is a JAPE transducer and this class is here to allow the specification
 * in creole.xml of a default grammar to be used in .
 */
@CreoleResource(name = "SnoMedRules")
public class SnoMedRules extends Transducer {

  private static final long serialVersionUID = 3L;

  /**
   * The ontology parameter is not used for this PR and therefore hidden.
   *
   * @param ontology
   */
  @HiddenCreoleParameter
  @Override
  public void setOntology(gate.creole.ontology.Ontology ontology) {
    super.setOntology(ontology);
  }

  /**
   * The binaryGrammarURL parameter is not used for this PR and therefore hidden.
   *
   * @param url
   */
  @HiddenCreoleParameter
  @Override
  public void setBinaryGrammarURL(URL url) {
    super.setBinaryGrammarURL(url);
  }


  /**
   * The grammarURL parameter provides the SnoMedTagger main.jape file as a default
   * for this PR.
   *
   * @param newGrammarURL
   */
  @CreoleParameter(
    comment = "The URL to the grammar file.",
    suffixes = "jape",
    defaultValue = "resources/Rules/main.jape"
  )
  @Override
  public void setGrammarURL(java.net.URL newGrammarURL) {
    super.setGrammarURL(newGrammarURL);
  }

}