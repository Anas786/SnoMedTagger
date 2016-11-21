SnoMedTagger : SNOMED CT Medical Tagger
  Developed by Hafiz Muhammad Anas, Contact : anas_abdani@hotmail.com Or hanas@knysys.com
  Developed by Saman Hina, Contact : saman.hina@gmail.com Or scsh@leeds.ac.uk
  -----------------------------------------------------------------------------------
  Copyright (c) 2012-2013, The University of Leeds.
  This application is developed as part of GATE (see http://gate.ac.uk/), and is free
  for research purposes 
  Saman Hina, 18-04-2012

Steps to install SnoMedTagger plugin:

* Install SnoMed from manage Creole Plugin tab in GATE.
* Install tool from manage Creole Plugin tab in GATE.

Steps to create pipeline to Run Application: 

* create pipeline as follows :
  
  * Document Reset
  * English Tokenizer
  * Sentence Splitter
  * POS Tagger
  * Morphological Analyser
  * SnoMed Gazetteer
  * Flexible Gazetteer
  * SnoMed Rules


