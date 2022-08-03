# Working-with-web-Crawler-using-Selenium
Assignment 2 W9D4 - SDA - Software QA Bootcamp

## Table of contents
* [Question](#question)
* [Answer](#answer)
* [Output Screenshots](#output-screenshots)

---
## Question
Retrieve the information from a table in the website with a java application that is used to crawl a Web on top of the Selenium library.


## Answer
Web Crawling is useful to automate certain tasks performed routinely and popular way of information gathering mechanism on websites.

and I used for solving this assignment the following reference [Web Crawling [Java][Selenium]](https://medium.com/tech-vision/web-crawling-java-selenium-8805fc006db1)


### First:
Setup Latest Web Driver for Chrome  Driver.
Donwload the necessary jar files:
- Selenium (Lastest).
- TestNG (Lastest).
- commander (Lastest).

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_.

### Third:
I opened the website, then take web elements, and then add them to the code.

- Read page content

```md
String content = driver.getPageSource();
System.out.println(content);
```

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182680605-f1b6307e-4d7d-4637-8c13-67260229b5a2.png" width=60% height=60%>
</p>

- Find the table element

```md
WebElement table = driver.findElement(By.xpath("//table[@class='grid versions']"));
```

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182680753-19417f08-13fa-45df-9e6b-39e5eaae7ad1.png" width=60% height=60%>
</p>


- Go through each major version

```md
List<WebElement> mainVersions = table.findElements(By.tagName("tbody"));

		for (WebElement mver : mainVersions) {
			for (WebElement ver : mver.findElements(By.tagName("tr"))) {
			}
		}
```

- Get all anchor tags then find each relevant web element that contains required information 

```md
// Get all anchor tags
List<WebElement> attributes = ver.findElements(By.tagName("a"));

// Find each relevant web element that contains required information
WebElement version = attributes.get(0);
WebElement repository = attributes.get(1);
WebElement usages = attributes.get(2);
WebElement date = Iterables.getLast(ver.findElements(By.tagName("span")));

System.out.println("Version    : " + version.getText());
System.out.println("Repository : " + repository.getText());
System.out.println("Usages     : " + usages.getText());
System.out.println("Date       : " + date.getText());
System.out.println("------------------------------");
```

---
## Output Screenshots:
- Page content
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182682215-33f0a830-b22d-4254-8cc2-e47a87c2539b.png" width=80% height=80%>
</p>


- The retrieved data from  the table
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182682470-72949d2e-68ea-43a5-bbb8-16ed06ddc486.png" width=20% height=20%>
</p>


- Result
<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/182681980-24cd368c-40bd-4991-aaaf-f9d0ef8e059d.png" width=80% height=80%>

https://user-images.githubusercontent.com/48597284/182682075-dadf0625-5c1a-4c45-b507-1c6d6272366c.mp4
</p>
