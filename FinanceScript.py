# Starting the query of finance data 

stockList = "CSCO"
url = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY_ADJUSTED&symbol=" + stockList +"&apikey=FF4CIPERU65DWNNC"
print(url)