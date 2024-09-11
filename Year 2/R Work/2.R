
# Sampling distributions
# From the lecture notes Section 3.3:
#   “The ‘sampling distribution’ of a sample statistic is NOT the same as the ‘sample distribution’
# which is the distribution of the raw data in the sample.”
# In this lab session, we are going to explore this statement for ourselves.
# Samples that are normally distributed.
# Simulate 1000 datasets, each of size 10, from a N(100,16) distribution. Note that we always write N(µ, σ
#                                                                                                      2
# ),
# so 16 is the variance, not the standard deviation.
# • Compute the mean for each sample and store it in a new vector. Display the first six means. What is
# the matrix() function doing? You can run the code ?matrix to find out more.
# Set the seed value
set.seed(8423)
# Simulate values from the normal distribution
simdata <- rnorm(n = 10000, mean = 100, sd = 4)
# Create a matrix with 1000 samples in each row of 10 columns
1
matrixdata <- matrix(simdata, nrow = 1000, ncol = 10)
# Compute the mean of each sample (each row) and print the first six means
means <- apply(matrixdata, 1, mean)
means[1:6]
## [1] 99.63755 99.94784 100.19990 102.21240 101.05745 97.88532


# • Construct a histogram of the first six samples. Note, in the code that follows, we are using a loop to
# construct multiple histograms, instead of writing out the hist code several times. Examine the code,
# and think about what par, matrixdata[i,] and paste0 are doing. You can run the code ?par to find
# out more about it.
# Plot the first six samples
par(mfrow=c(3,2), mar=c(4,4,4,1), oma=c(0.5,0.5,0.5,0))
for (i in c(1:6)){
  hist(matrixdata[i,], main = paste0("Sample ", i), xlab = "Values",
       cex.main = 1.5, cex.lab = 1.2, cex.axis = 1.2,
       ylim = c(0,5), xlim = c(85,115))
}

# Sample 1
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# Sample 2
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# Sample 3
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# Sample 4
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# Sample 5
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# Sample 6
# Values
# Frequency
# 85 90 95 100 105 110 115
# 0
# 3
# 2


# Reset the number of plots that appear in the window at a time
par(mfrow=c(1,1))


# • Now construct a histogram of the sample means from each of the 1000 samples.
# Generate histogram (keeping the y scale the same as the earlier graphs for comparison)
hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(85,115))

# Histogram of the sample means
# Sample mean
# Frequency
# 85 90 95 100 105 110 115
# 0 50 100 150
# • How would you describe this sampling distribution? What do you notice when you compare it to the
# histograms of the samples? (Note that the x-axis is on the same scale as the earlier graphs to aid
#                             comparison.)
# Samples that are exponentially distributed.
# Simulate 1000 datasets, each of size 10, from a exponential distribution with λ = 0.5. From properties of
# exponential distributions, what is the mean and variance of this distribution?

# Set the seed value
  set.seed(96358285)
  
# Simulate values from the exponential distribution
3
simdata <- rexp(n = 10000, rate = 0.5)

# Create a matrix with 1000 samples in each row of 10 columns
matrixdata <- matrix(simdata, nrow = 1000, ncol = 10)

# • Compute the mean for each sample and store it in a new vector. Display the first six means.
#Compute the mean of each sample (each row)
means <- apply(matrixdata, 1, mean)
means[1:6]

## [1] 1.684177 2.168568 1.604019 1.704819 2.696661 1.570264
# • Construct a histogram of the first six samples.
# Plot the first six samples

par(mfrow = c(3,2), mar = c(4,4,4,1), oma = c(0.5,0.5,0.5,0))
for (i in c(1:6)){
  hist(matrixdata[i,], main = paste0("Sample ", i), xlab = "Values",
       cex.main = 1.5, cex.lab = 1.2, cex.axis = 1.2,
       ylim = c(0,8), xlim = c(0,10))
}

# Reset the number of plots that appear in the window at a time
par(mfrow = c(1,1))

# • Now construct a histogram of the sample means from each of the 1000 samples.
# Generate histogram (keeping the y scale the same as the earlier graphs for comparison)
hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(0, 10))

# 1. Simulate 1000 datasets each of size 5 from a N(50, 9) distribution. Use the seed value 6594. Find the
# mean for each sample and store them in a new vector (this vector will contain 1000 values). Generate
# a histogram of this vector of sample means.

# Set the seed value
set.seed(6594)
# Simulate values from the normal distribution
simdata <- rnorm(n = 1000, mean = 50, sd = 9)
# Create a matrix with 1000 samples in each row of 5 columns
matrixdata <- matrix(simdata, nrow = 1000, ncol = 5)
# Compute the mean of each sample (each row) and print the first six means
means <- apply(matrixdata, 1, mean)
means[1:6]

hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(0,100))

# 2. Repeat the previous question, but this time use a sample size of 30 in the 1000 datasets. Use the seed
# value 9278. Use the same range on the histogram x-axis as in question 1.



# Set the seed value
set.seed(9278)
# Simulate values from the normal distribution
simdata <- rnorm(n = 1000, mean = 50, sd = 9)
# Create a matrix with 1000 samples in each row of 30 columns
matrixdata <- matrix(simdata, nrow = 1000, ncol = 30)
# Compute the mean of each sample (each row) and print the first six means
means <- apply(matrixdata, 1, mean)
means[1:6]

hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(0,100))

# 3. Simulate 1000 datasets each of size 5 from an exponential distribution with lambda = 0.4. Use the seed
# value 3845. Find the mean for each sample and store them in a new vector (this vector will contain
# 1000 values). Generate a histogram of this vector of sample means.


set.seed(3845)
simdata <- rexp(n = 10000, rate = 0.4)
# Create a matrix with 1000 samples in each row of 5 columns
matrixdata <- matrix(simdata, nrow = 1000, ncol = 5)
# Compute the mean of each sample (each row) and print the first six means
means <- apply(matrixdata, 1, mean)
hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(0,20))

# 4. Repeat the previous question, but this time use a sample size of 30 in the 1000 datasets. Use a seed
# value of 8651. Use the same range on the histogram x-axis as in question 3.

set.seed(8651)
simdata <- rexp(n = 10000, rate = 0.4)
# Create a matrix with 1000 samples in each row of 5 columns
matrixdata <- matrix(simdata, nrow = 1000, ncol = 30)
# Compute the mean of each sample (each row) and print the first six means
means <- apply(matrixdata, 1, mean)
hist4 <- hist(means, main = "Histogram of the sample means", xlab = "Sample mean", xlim = c(0,20))

# 5. Create a plot with all four histograms of means in one.

par(mfrow=c(2,2), mar=c(4,4,4,1), oma=c(0.5,0.5,0.5,0))
