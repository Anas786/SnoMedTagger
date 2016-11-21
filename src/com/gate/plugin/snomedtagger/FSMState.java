/* SnoMedTagger : SNOMED CT Medical Tagger
 *  Developed by Hafiz Muhammad Anas, Contact : anas_abdani@hotmail.com Or hanas@knysys.com
 *  Developed by Saman Hina, Contact : saman.hina@gmail.com Or scsh@leeds.ac.uk
 *  -----------------------------------------------------------------------------------
 *  Copyright (c) 2012-2013, The University of Leeds.
 *  This application is developed as part of GATE (see http://gate.ac.uk/), and is free
 *  for research purposes 
 *  Saman Hina, 18-04-2012
 *  -----------------------------------------------------------------------------------
 *  FSMState.java
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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.gate.plugin.snomedtagger.SnoMedGazetteer.CharMap;
import gate.creole.gazetteer.Lookup;

/** Implements a state of the deterministic finite state machine of the
 * gazetter.
 *
 */
public class FSMState implements Serializable {

  private static final long serialVersionUID = -3339572027660481558L;

  /** Constructs a new FSMState object and adds it to the list of
   * states of the {@link SnoMedGazetteer} provided as owner.
   *
   * @param owner a {@link SnoMedGazetteer} object
   */
  public FSMState(SnoMedGazetteer owner) {
    myIndex = index++;
    owner.fsmStates.add(this);
  }

  /** Adds a new value to the transition function
   */
// >>> DAM: was - to use CharMap
/*
  void put(Character chr, FSMState state) {
    transitionFunction.put(chr,state);
  }
*/
// >>> DAM: TransArray optimization
  public void put(char chr, FSMState state) {
    transitionFunction.put(chr,state);
  }
// >>> DAM: end

  /** This method is used to access the transition function of this state.
   */

  public FSMState next(char chr) {//UnicodeType type){
    return (FSMState)transitionFunction.get(chr);
  }
  public String getEdgesGML() {
    String res = "";
    char currentChar;
    FSMState nextState;

    for (int i = 0; i < transitionFunction.itemsKeys.length; i++)
    {
      currentChar = transitionFunction.itemsKeys[i];
      nextState = next(currentChar);
      res += "edge [ source " + myIndex +
      " target " + nextState.getIndex() +
      " label \"'" + currentChar + "'\" ]\n";
    }
    return res;
  }
  /** Checks whether this state is a final one
   */
  public boolean isFinal() {
    if (lookupSet==null)
        return false;
    return !lookupSet.isEmpty();
  }

  /** Returns a set of {@link Lookup} objects describing the types of lookups
   * the phrase for which this state is the final one belongs to
   */
  public Set<Lookup> getLookupSet(){return lookupSet;}

  /** Adds a new looup description to this state's lookup descriptions set
   */
  public void addLookup(Lookup lookup) {
    if (lookupSet == null)
        lookupSet = new HashSet<Lookup>(4);
    lookupSet.add(lookup);
  } // addLookup

  /** Removes a looup description from this state's lookup descriptions set
   */
  public void removeLookup(Lookup lookup) {
    lookupSet.remove(lookup);
  } // removeLookup

  /** Returns the unique ID of this state.
   */
  public int getIndex(){ return myIndex; }


  /** The transition function of this state.
   */
  protected CharMap transitionFunction = new CharMap();
  protected Set<Lookup> lookupSet;
  /**
   * The unique id of this state. This value is never used by the algorithms but
   * it can be useful for graphical representations.
   */
  protected int myIndex;

  /**
   * Class member used to generate unique ids for the instances
   *
   */
  private static int index;

  static{
    index = 0;
  }

}