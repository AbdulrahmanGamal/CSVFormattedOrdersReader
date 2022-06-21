## App using kotlin that reads .csv files containing list of orders and doing some calculations on them 


#### To run the application make sure you have  java jdk and kotlin 

####  from command line in the project root directory run the following steps

```bash
kotlinc src src/solution -include-runtime -d main.jar
```
Then run the generated jar file using 
```bash
java -jar main.jar
```
then enter the input which is the file name for example: 
```bash
order_log00.csv
```
- after running this project from main file you will be asked to enter csv file name stdin like :"order_log00.csv" 
which should be located in the root app directory
####
- output files will be created in the same directory with name 0_fileName,1_fileName

### Example of created files in the app directory

![](readme_images/problem-solving-image-1.PNG)

### Project Structure
 - solution.fileparsers : This app containing file package parsers which applying facade pattern to extract any type of files in the future to make the app more scalable
 - solution.models : Order needed solution.models to easily do some processing on the extracted data  
 - solution.ordercalculations : Helper classes to calculate the average per order, and most ordered brands

### App data extraction class diagram 
![](readme_images/extraction_class_diagram.PNG)

