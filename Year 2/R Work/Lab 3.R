# Constructing confidence intervals
# Examine the data
# A random sample of data was collected from a population and recorded as:
# Create a vector containing the data
data <- c(13.1, 19.6, 21.3, 11.6, 15.4, 23.7, 18.6, 16.1, 19.3, 17.4, 21.5, 16.8, 14.9)
# Print out the data
data

# It was assumed that this data comes from a normally distributed population. To see if this is reasonable,
# we will construct a histogram for the data.
# Generate a histogram
hist(data)

# Make the CI using t.test.
# We can generate CIs using the t.test() function in R. The default is 95% confidence.
# Find the confidence interval using t.test (default is 95% confidence interval)
t.test(data)

# We see that the 95% confidence interval is: (15.54, 19.74).
# • What is the interpretation of this confidence interval?
# We are 95% confident that the true population mean µ lies between 15.54 and 19.74.

# • What is the hypothesis test that is also being tested in the above output?
#   H0 : µ = 0, versus HA : µ ̸= 0

# • Is this a sensible hypothesis here?
#   We have no idea! No context was given, and hypotheses should be specified based on prior belief about the
# mean of the population. By default, R will test against 0, but we can change the default. Check out all the
# options by running ?t.test
# By default, t.test returns a 95% confidence interval. We can also find a 90% confidence interval.

# • Before looking at the output below, would you expect to see a narrower or wider interval than the 95%
# interval above?
  # Find the 90% confidence interval using t.test
  t.test(data, conf.level = 0.9)

  # Make the CI ‘manually’
  # Functions in R are a useful way to put together lines of code for use over and over.
  # For example, the following function called CI will produce a confidence interval for data x, a specified alpha
  # level and presented rounded to a certain number of decimal places. Go through each line of code in the
  # function and search the R help files to make sure you know what each line is doing.
  # Create a function where x is the data and alpha to determine the level
  # of confidence (100*(1-alpha)%)
  
  CI <- function(x, alpha, round) {
    n <- length(x)
    m <- mean(x)
    s <- sd(x)
    se <- s/sqrt(n)
    tval <- qt(0.5*alpha, df = n-1, lower.tail=FALSE )
    round(c( m - tval * se, m + tval * se ), round)
  }
  
  
  
  # We can use this function now to construct confidence intervals for the data above.
  
  # • A 95% confidence interval:
    # Create a function where x is the data and alpha to determine the level
    # of confidence (100*(1-alpha)%)
    CI(x = data, alpha = 0.05, round = 2)
  ## [1] 15.54 19.74
    
  # • A 90% confidence interval:
    # Create a function where x is the data and alpha to determine the level
    # of confidence (100*(1-alpha)%)
    CI(x = data, alpha = 0.1, round = 2)
  ## [1] 15.92 19.36
    
    
    
    # Simulation study
    # Simulate 1000 datasets each of size 15 from N(35, 9).
    # Simulate 1000 datasets of size 15 from N(35, 9) and store in a matrix
    set.seed(2646537)
    mean_val = 35
    sd_val = 3
    samples = 1000
    size = 15
    x_sim <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                    ncol=size, byrow=TRUE)
    head(x_sim)
    
    # Construct 95% confidence intervals for each dataset and find the proportion of confidence intervals that
    # contain the true µ value.
    # To do this, we will write a new function called coverage.
    # Create the function coverage
    coverage <- function(X, alpha, mu, round) {
      CIs <- matrix(nrow=nrow(X), ncol=2)
      for(k in 1:nrow(X)) CIs[k, ] <- CI(X[k,], alpha, round)
      z <- (CIs[,1] < mu) * (CIs[ , 2 ] > mu)
      sum(z)/nrow(X)
    }
    # To use the function, we specify the input values as follows. It will return the proportion of intervals from
    # our simulated dataset that contained the true µ value (here µ = 35 as specified above).
    # Call the function coverage:
    coverage(X = x_sim, alpha = 0.05, mu = mean_val, round = 2)
    
    # Questions
    # 1. A sample of data was collected from a normally distributed population. The values are: 69, 74, 79, 81,
    # 85, 86, 89, 90, 94, 97, 100, 105. Generate a 99% confidence interval for the data using t.test.
    
    # Create a vector containing the data
    data1 <- c(69, 74, 79, 81, 85, 86, 89, 90, 94, 97, 100, 105)
    t.test(data1, conf.level = 0.99)
    
    # 2. Generate the same 99% CI using the manual function created in the earlier section.
    
    CI <- function(x, alpha, round) {
      n <- length(x)
      m <- mean(x)
      s <- sd(x)
      se <- s/sqrt(n)
      tval <- qt(0.5*alpha, df = n-1, lower.tail=FALSE )
      round(c( m - tval * se, m + tval * se ), round)
    }
    
    CI(x = data1, alpha = 0.01, round = 2)
    
    # 3. Repeat the previous two questions for a 90% confidence interval. Before you write the code, do you
    # expect to get a wider or narrower interval here?
    t.test(data1, conf.level = 0.90)
    CI(x = data1, alpha = 0.1, round = 2)
    
    # 4. Using the code and functions above, do a simulation study to find the coverage of 95% confidence
    # intervals constructed from samples of size 20 drawn from a N(50, 16) population. Use a seed value
    # of 9498. Use 1000 simulated samples. Repeat for 10,000, 100,000 and 1,000,000 (but keep the same
    # seed). What do you find as the number of simulated samples increases?
    
    #1000
    set.seed(9498)
    mean_val = 50
    sd_val = 4
    samples = 1000
    size = 20
    x_sim_1 <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                    ncol=size, byrow=TRUE)
    
    #10,000
    set.seed(9498)
    mean_val = 50
    sd_val = 4
    samples = 10000
    size = 20
    x_sim_2 <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                      ncol=size, byrow=TRUE)
    #100,000
    set.seed(9498)
    mean_val = 50
    sd_val = 4
    samples = 100000
    size = 20
    x_sim_3 <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                      ncol=size, byrow=TRUE)
    #1,000,000
    set.seed(9498)
    mean_val = 50
    sd_val = 4
    samples = 1000000
    size = 20
    x_sim_4 <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                      ncol=size, byrow=TRUE)
    
    # Create the function coverage
    coverage <- function(X, alpha, mu, round) {
      CIs <- matrix(nrow=nrow(X), ncol=2)
      for(k in 1:nrow(X)) CIs[k, ] <- CI(X[k,], alpha, round)
      z <- (CIs[,1] < mu) * (CIs[ , 2 ] > mu)
      sum(z)/nrow(X)
    }
    
    # Call the function coverage:
    coverage(X = x_sim_1, alpha = 0.05, mu = mean_val, round = 2)
    coverage(X = x_sim_2, alpha = 0.05, mu = mean_val, round = 2)
    coverage(X = x_sim_3, alpha = 0.05, mu = mean_val, round = 2)
    coverage(X = x_sim_4, alpha = 0.05, mu = mean_val, round = 2)
    
    # 5. If you have time at the end, rerun your simulation study under different conditions, for example, you
    # could change the mean of the distribution or the sample size.
    
    set.seed(9498)
    mean_val = 44
    sd_val = 42
    samples = 1222
    size = 122
    x_sim_6 <- matrix(rnorm(samples*size, mean = mean_val, sd = sd_val), nrow=samples,
                      ncol=size, byrow=TRUE)
    
    coverage(X = x_sim_6, alpha = 0.05, mu = mean_val, round = 2)