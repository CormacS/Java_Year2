Author: Cormac Smith
Date Due: 12/04/2019

I chose to do a Topic Modeller. I read in two files and
take the top 10 most common words in each. I also had a file of stopwords,
these were used to remove words like the, a, and etc from the list.
When creating the topic modeller I decided to use Hashmaps.
This is because they hold a key and have a value attacthed to it. I thought
this would good to use as the word can be a key, while the amount of times
it occurs being the value. 

Classes:
-GUI
My GUI class implements the interface, I have serveral buttons that allow the
user to easily understand what they are able to do. I have error checking
so the user cant compare the files without selecting them first.
I didnt put any error checking on what extra words the user can input, as if
they want to input numbers or special characaters that are irelevant and will
take more time to process, I felt like that is their choice.

-Compare
I used LinkedHashMaps, because this way the Hashmaps order will stay the same
as it was entered. I have an if statement with if(counter == 10) then break
this is because I only want the top 10 words from the hashmap. 

-FileProcessing
This class has the main functionallity in it. I feel like I've explained all
I need to in the comments of the code itself.

One part of the code I took from online, it was organising the Hashmaps by
highest value, since we had not gone over Hashmaps at the time, I needed to
source my answer online.
The website can be found here: 
https://codippa.com/how-to-sort-a-map-in-java-8-sort-a-map-using-stream/

Extra things I'd like to implement/do with more time would be:
- A Marking Scheme
	I feel like I would have done the comparision part a bit different
	due to small texts not really having many words in it,some of the bottom
	tier words are there based on alphabetical order, I would like to put
	more emphasis on the top 5 and how in common those are along with the 
	remaining 5. 
- Remove the redundant code
	I believe there is redundant code that I would like to remove, instead
	of had the same code twice for the 2 files, just have the 1 code and
	put both files through it. This would clean up the code for sure.
















