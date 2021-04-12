# metric-imperial-converter
Metric and Imperial Converter
## Table of contents
* [Area Conversion](#area-conversion)
* [Length Conversion](#length-conversion)
* [Volume Conversion](#volume-conversion)
* [Mass Conversion](#mass-conversion)
* [Temperature Conversion](#temperature-conversion)
* [Setup](#setup)
* [Sample Post Request](#sample-post-request)


## General info
This project is simple metric and imperial converter.
	
## Area Conversion
sample Conversion Units : m2, mm2, ha, yd2, a
* see AreaUnitsOfMeasure enum for more

## Length Conversion
sample Conversion Units : m, mm, yd, ft, in
* see LengthUnitsOfMeasure enum for more

## Volume Conversion
sample Conversion Units : cm3, pt, gal, in3, ft3
* see VolumeUnitsOfMeasure enum for more

## Mass Conversion
sample Conversion Units : kg, lb, cwt, oz, t
* see MassUnitsOfMeasure enum for more

## Temperature Conversion
sample Conversion Units : C, F, K
	
## Setup
To run this project in docker environment
```
$ docker build --tag=metric-imperial-converter:latest .
$ docker run -p8080:8080 metric-imperial-converter:latest
```
## Sample Post Request
using insomina/postman
* POST localhost:8080/convert
```
{
	"conversionType" : "TEMPERATURE",
	"inputValue" : 4534,
	"convertUnitFrom":"F",
	"convertUnitTo":"K"
}
```

