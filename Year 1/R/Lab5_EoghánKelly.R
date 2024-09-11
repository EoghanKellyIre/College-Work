#1)

#a)
#Loading the pressure dataset
head(pressure)
#Check the correlation between the variables
cor(pressure$temperature, pressure$pressure)

#b)
#Creating a scatter plot of the data that shows both the points and a smoothed line of the points
scatter.smooth(x=pressure$temperature, y=pressure$pressure, main="Pressure ~ Temperature")

#c)
#Creating side-by-side box-plots of each variable
par(mfrow=c(1, 2))  # divide graph area in 2 columns
boxplot(pressure$temperature, main="Temperature") # box plot for 'temperature'
boxplot.stats(pressure$temperature)$out # display outliers
boxplot(pressure$pressure, main="Pressure")  # box plot for 'Pressure'
boxplot.stats(pressure$pressure)$out # display outliers

#d)
par(mfrow=c(1, 2))  # divide graph area in 2 columns
plot(density(pressure$temperature), main="Density Plot: Temperature")  # density plot for 'Temperature'
plot(density(pressure$pressure), main="Density Plot: Pressure")  # density plot for 'Pressure'

#2)

#a)
#We can fit our linear model as follows:
pressure.lm <- lm(temperature ~ pressure, data=pressure)  # build linear regression model on full data
summary(pressure.lm)#And now we can inspect the results

#b)
par(mfrow=c(1, 1))  # back to 1 plot
#Next, we can visualise our regression line on a scatterplot of our data.
plot(pressure$temperature, pressure$pressure, main="Regression line on data")
abline(pressure.lm)

#c)
pressure.res <- resid(pressure.lm)#compute the residuals
#We can plot the residuals against the observed values
plot(pressure$temperature, pressure.res, ylab="Residuals", xlab="Temperature", 
     main="Pressure Linear Model") 
abline(0, 0)                  # the horizon
plot(density(pressure.res), main="Density Plot: residuals") #We can inspect the residuals density

#d)
#We can also see a number of other plots with a single command
plot(pressure.lm) # each plot individually
par(mfrow=c(2,2)) # 2x2 grid of plots
plot(pressure.lm)
par(mfrow=c(1, 1))  # back to 1 plot

#3)

#a)	Write an equation that describes the linear model you have fitted
#132+0.37x

#b)	Explain why the p-values for the variable temperature and the overall F test are so similar for this model.
#The f statistic is a test of the significance of the overall module. Since we have only one variable being tested,
#they are implicitly testing the same thing.

#c)	Comment on what you saw from the previous parts. Is the model appropriate?
mean(pressure.lm$residuals)
cor.test(pressure$temperature, pressure.lm$residuals)
#I don't think that the model is appropriate, since the relationship from this data appears to be exponential rather than linear.
  

