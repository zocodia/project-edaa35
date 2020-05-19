

# -fileNameKeys -fileNameValues -fileNameOutput -nbrIterations -Structure -measureType

# Rscript small.R input/keys.txt input/values.txt output/ut.txt 10 tree add

# read parameters
args = commandArgs(trailingOnly=TRUE)
base = "java -cp . Measure"
cmd = paste0(base, " ", args[1], " ", args[2], " ", args[3], " ", args[4], " ", args[5], " ", args[6])


# plot data
plotres <- function(file, s = 1) {
  data <- read.csv(file)
  data <- data[s:nrow(data),]
  #outlier <- which.max(data$measured)

  a = unlist(strsplit(args[3], "\\."))
  pdfpath = paste0(a, ".pdf")
  pdf(pdfpath)

  plot(data, type='l')
  #plot(data[-c(outlier),], type='l')

  dev.off()
}

system(cmd)


# view plot and save as pdf
plotres(args[3]) # plot to screen
