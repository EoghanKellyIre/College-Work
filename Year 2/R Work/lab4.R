# Read the data into R
exp <- read.csv("Lab4_ExperimentData.csv")
# View the first few lines of the data
head(exp)
# Scatterplot
plot(exp$Question, exp$Seconds, main = "Experiment time versus group",
     xlab = "Question", ylab = "Time to answer (seconds)")
# Fit and summarise the slr model fit to the data
lm1 <- lm(Seconds ~ Question, data = exp)
summary(lm1)
# Scatterplot with lm fit
plot(exp$Question, exp$Seconds, main = "Experiment time versus group", xlab = "Question", ylab = "Time to answer (seconds)")
abline(lm1)
# Store the residuals, standardised residuals and predicted values
resids <- resid(lm1)
sresids <- rstandard(lm1)
preds <- predict(lm1)
# Plot the standardised residuals
par(mfrow = c(1, 2), mar = c(5,6,2,2))
plot(preds, sresids, xlab = "Predicted", ylab = "Standardised residuals",
     main = "Standardised residuals versus predicted")
abline(h = 0)
# QQ probability plot
qqnorm(sresids, ylab="Standardised residuals", xlab="Normal Scores",
       main="QQ plot")
qqline(sresids)
par(mfrow = c(1,1), mar = c(5,4,4,2))





# 1. Restrict the full dataset to only groups 1 to 4. Use the which() function in R as follows.
# # Create a subset of the original dataset
exp_subset <- exp[which(exp$Question <5),]
summary(exp_subset)


plot(exp_subset$Question, exp_subset$Seconds, main = "Experiment time versus group",
     xlab = "Question", ylab = "Time to answer (seconds)")
# Fit and summarise the slr model fit to the data
lm1 <- lm(Seconds ~ Question, data = exp_subset)
summary(lm1)
# Scatterplot with lm fit
plot(exp_subset$Question, exp_subset$Seconds, main = "Experiment time versus group", xlab = "Question", ylab = "Time to answer (seconds)")
abline(lm1)

# 4
# 2. Fit a simple linear regression model to the subset of data, generate a scatter plot with the fitted model
# line included, and test the model assumptions. This is similar to what we did in class for this dataset.
# Done
# 3. There are several values in the restricted dataset that had Correct = 0. Is it appropriate to include
# these observations in the analysis? Repeat step 2 omitting incorrect responses. Start by creating
# exp_subset2 that excludes incorrect values using the which() function again. Do the results change
# much?
exp_subset2 <- exp_subset[which(exp_subset$Correct ==1),]
plot(exp_subset2$Question, exp_subset2$Seconds, main = "Experiment time versus group",
     xlab = "Question", ylab = "Time to answer (seconds)")
# Fit and summarise the slr model fit to the data
lm1 <- lm(Seconds ~ Question, data = exp_subset2)
summary(lm1)
# Scatterplot with lm fit
plot(exp_subset2$Question, exp_subset2$Seconds, main = "Experiment time versus group", xlab = "Question", ylab = "Time to answer (seconds)")
abline(lm1)

#   4. What next for analysing this dataset?

# Store the residuals, standardised residuals and predicted values
resids <- resid(lm1)
sresids <- rstandard(lm1)
preds <- predict(lm1)

# Plot the standardised residuals
par(mfrow = c(1, 2), mar = c(5,6,2,2))
plot(preds, sresids, xlab = "Predicted", ylab = "Standardised residuals",
     main = "Standardised residuals versus predicted")
abline(h = 0)
# QQ probability plot
qqnorm(sresids, ylab="Standardised residuals", xlab="Normal Scores",
       main="QQ plot")
qqline(sresids)
par(mfrow = c(1,1), mar = c(5,4,4,2))

#   5. Now we are going to work with a small dataset to reinforce the ideas behind SLR, least squares
# estimation and how to find residuals, and predicted values.
# • Carry out the following tasks:
#   – Read a vector of x values into R: 1, 2, 3, 4, 5, 6, 7, 8. Call it x.
# – Read a vector of y values into R: 15, 10, 21, 16, 19, 25, 21, 29. Call it y.
# – Create a scatter plot of y versus x.
# – Fit a simple linear regression model using the lm() function.
# – Verify the estimates of the least squares estimates of the intercept and slope using a series of
# manual functions in R (such as xbar = mean(x), and sumxsq = sum(xˆ2)). (Go back to the
#                                                                         lecture notes for the formulae for OLS estimation of the SLR model.)
# – Store the residual and predicted values from the lm fitted model and combine them into a data
# frame with the original data (use the data.frame() function)
# – Print out the dataset, and verify by hand the values for the residuals and predicted values in
# rows 1 and 2.


x <- c(1, 2, 3, 4, 5, 6, 7, 8)
y <- c(15, 10, 21, 16, 19, 25, 21, 29)
plot(x, y, main = "Experiment x vs y",
     xlab = "X", ylab = "y")
# Fit and summarise the slr model fit to the data
lm1 <- lm(x ~ y)
summary(lm1)
# Scatterplot with lm fit
plot(x, y, main = "Experiment x versus y")
abline(lm1)

