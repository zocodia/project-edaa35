

**Kompilera efter ändring i java-kod:**

    > javac Measure.java IO.java  


**small.R kör bara java-programmet en gång och plottar resultat i pdf i output, samt ger res i textfil i output**
   
    > Rscript small.R [fileNameKeys] [fileNameValues] [fileNameOutput] [nbrIterations] [structure] [measureType]

    [fileNameKeys]    - inkludera path till input dir för enkelhet
    [fileNameValues]  - samma som ovan
    [fileNameOutput]  - inkludera path till output dir
    [nbrIterations]   - hur många gånger java-programmet ska find,add elr remove
    [structure]       - datastruktur att testa: tree eller hash
    [measureType]     - find, add eller remove



**large.R kör java-programmet ett visst antal gånger och räknar ut konfidensintervall och medelvärde**
  
    > Rscript large.R [fileNameKeys] [fileNameValues] [fileNameOutput] [nbrIterations] [structure] [measureType] [nbrOfRuns]

    [nbrOfRuns]       - hur många gånger R-scriptet ska köra java-programmet  



**Exempel**

    > Rscript small.R input/keys.txt input/values.txt output/ut.txt 10 tree find

    > Rscript large.R input/keys.txt input/values.txt output/ut.txt 100 tree find 10
