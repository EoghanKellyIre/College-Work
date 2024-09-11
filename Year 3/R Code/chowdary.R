chowdary <- read.csv("D:\\Trintiy\\Junior Sophister\\Semester 1\\Multivariate Linear Analysis\\Assignment\\chowdary (1).csv")


head(chowdary, n = 5)

chowdary_B <- chowdary[1:62,]
chowdary_C <- chowdary[63:104,]

column_means <- colMeans(chowdary[, 3:184])
hist(column_means)
range(column_means)
names <- colnames(chowdary[, 3:184])
sapply(chowdary[, 3:184],var)

#PART ONE

chowdary_PC <- prcomp(chowdary[, 3:184])
chowdary_PC_stand <- prcomp(chowdary[, 3:184], scale=TRUE)

print(chowdary_PC)
summary(chowdary_PC)
summary(chowdary_PC_stand)


plot(chowdary_PC, main = "chowdary's Data", type = "l")
plot(chowdary_PC_stand, main = "chowdary's Data", type = "l")


chowdary_PC_var_explain <- (chowdary_PC$sdev^2) / (sum(chowdary_PC$sdev^2))
plot(chowdary_PC_var_explain, type = "b", main = "chowdary Data", 
     xlab = "No. of components", ylab = "Proportion of variance explained", xaxt = "n")
axis(1, at = 1:102)

chowdary_PC_var_explain <- (chowdary_PC_stand$sdev^2) / (sum(chowdary_PC_stand$sdev^2))
plot(chowdary_PC_var_explain, type = "b", main = "chowdary Data Stand", 
     xlab = "No. of components", ylab = "Proportion of variance explained", xaxt = "n")
axis(1, at = 1:102)

chowdary_colors <- cbind(chowdary[1:62,], color= c("blue"))
chowdary_colors_temp <- cbind(chowdary[63:104,], color= c("red"))
chowdary_colors <- rbind(chowdary_colors, chowdary_colors_temp)

plot(chowdary[,3], chowdary[, 4], col=chowdary[, 185])

barplot(chowdary_PC$rotation[,1], main = "chowdary PC 1")

new_chowdary <- predict(chowdary_PC)

pairs(new_chowdary)


plot(chowdary_PC[,3], chowdary_PC[,4], type="n", xlab="PC1", ylab="PC2")
text(chowdary_PC[,3], chowdary_PC[,4], labels=substr(chowdary[,2],3,4), col=as.integer(chowdary[,2]))



#Part TWO

chowdary_dis <- dist(chowdary_B, method = "minkowski")
chowdary_dis_mat <- as.matrix(chowdary_dis)


chowdary_dis <- dist(chowdary, method = "minkowski")
chowdary_dis_mat <- as.matrix(chowdary_dis)

clust1 <- hclust(chowdary_dis, method = "average")
clust2 <- hclust(chowdary_dis, method = "single")
clust3 <- hclust(chowdary_dis, method = "complete")
plot(clust1, labels = FALSE, main = "average")
recommended_cut_off_height <- mean(clust1$height) + 3*sd(clust1$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust2, labels = FALSE, main = "single")
recommended_cut_off_height <- mean(clust2$height) + 3*sd(clust1$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust3, labels = FALSE, main = "complete")
recommended_cut_off_height <- mean(clust3$height) + 3*sd(clust1$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)
