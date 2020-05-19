
source("R_resources.R")

# köra java programmet flera gånger
# presentera konf.intervall, medelvärde


# get parameters
args = commandArgs(trailingOnly=TRUE)
base = "java -cp . Measure"
cmd = paste0(base, " ", args[1], " ", args[2], " ", args[3], " ", args[4], " ", args[5], " ", args[6])

nbrOfRuns = args[7]


# get mean values
getMean <- function(n) {
  all_mean <- c()

  for (i in c(1:n)) {
    posOfequal <- 1
    system(cmd)
    d <- read.csv(args[3])
    d <- d[posOfequal:nrow(d),]
    all_mean <- c(all_mean, mean(d$measured))
  }
  all_mean
}


# get mean value and confidence interval
all_mean <- getMean(nbrOfRuns)
meanOfmean <- mean(all_mean)
confint <- confidenceInterval(all_mean)


# print results
print(all_mean)
print(meanOfmean)
print(confint)
