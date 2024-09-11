chowdary <- read.csv("D:\\Trintiy\\Junior Sophister\\Semester 1\\Multivariate Linear Analysis\\Assignment\\Assignment 1\\chowdary (1).csv")
chowdary_colors <- cbind(chowdary[1:62,], color= c("blue"))
chowdary_colors_temp <- cbind(chowdary[63:104,], color= c("red"))
chowdary_colors <- rbind(chowdary_colors, chowdary_colors_temp)#

column_means <- colMeans(chowdary[, 3:184])
sapply(chowdary[, 3:184],var)
hist(column_means)
range(column_means)

#PART ONE

chowdary_PC_stand <- prcomp(chowdary_colors[, 3:184], scale=TRUE)

print(chowdary_PC_stand)
summary(chowdary_PC_stand)


plot(chowdary_PC_stand, main = "chowdary's Data", type = "l")

chowdary_PC_var_explain <- (chowdary_PC_stand$sdev^2) / (sum(chowdary_PC_stand$sdev^2))
plot(chowdary_PC_var_explain, type = "b", main = "chowdary Data Stand", 
     xlab = "No. of components", ylab = "Proportion of variance explained", xaxt = "n", xlim = c(1, 10) )
axis(1, at = 1:10)

plot(chowdary_colors[,3], chowdary_colors[, 4], col=chowdary_colors[, 185])

barplot(chowdary_PC_stand$rotation[,1], main = "chowdary PC 1")
barplot(chowdary_PC_stand$rotation[,2], main = "chowdary PC 2")
barplot(chowdary_PC_stand$rotation[,3], main = "chowdary PC 3")
barplot(chowdary_PC_stand$rotation[,4], main = "chowdary PC 4")



new_chowdary_stand <- predict(chowdary_PC_stand)

pairs(new_chowdary_stand[ , 1:4], col=chowdary_colors[,185])

plot(new_chowdary_stand[,1], new_chowdary_stand[,2], type="n", xlab="PC1", ylab="PC2")
text(new_chowdary_stand[,1], new_chowdary_stand[,2], labels=substr(chowdary_colors[,2],1,1), col=chowdary_colors[,185])

plot(new_chowdary_stand[,1], new_chowdary_stand[,4], type="n", xlab="PC1", ylab="PC4")
text(new_chowdary_stand[,1], new_chowdary_stand[,4], labels=substr(chowdary_colors[,2],1,1), col=chowdary_colors[,185])


#PART TWO

chowdary_B_norm <- chowdary[1:62, 3:184]

#chowdary_B_norm <- chowdary[3:62, 3:184]

chowdary_C_norm <- chowdary[63:104, 3:184]

chowdary_B_sd <- apply(chowdary_B_norm, 2 ,sd)
chowdary_C_sd <- apply(chowdary_C_norm, 2 ,sd)

chowdary_B <- sweep(chowdary_B_norm, 2, chowdary_B_sd, "/")
chowdary_C <- sweep(chowdary_C_norm, 2, chowdary_C_sd, "/")


chowdary_dis_B <- dist(chowdary_B, method = "minkowski", p=1)
chowdary_dis_C <- dist(chowdary_C, method = "minkowski", p=1)
chowdary_dis_mat_B <- as.matrix(chowdary_dis_B)
chowdary_dis_mat_C <- as.matrix(chowdary_dis_C)

#B
clust1_B <- hclust(chowdary_dis_B, method = "average")
clust2_B <- hclust(chowdary_dis_B, method = "single")
clust3_B <- hclust(chowdary_dis_B, method = "complete")
plot(clust1_B, main = "Breast samples using average linkage", xlab = "Index", ylab = "Height")
recommended_cut_off_height <- mean(clust1_B$height) + 3*sd(clust1_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust3_B, main = "Breast samples using Complete linkage")
recommended_cut_off_height <- mean(clust3_B$height) + 3*sd(clust3_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust2_B, main = "Breast samples using single linkage")
recommended_cut_off_height <- mean(clust2_B$height) + 3*sd(clust2_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

#C
clust1_C <- hclust(chowdary_dis_C, method = "average")
clust2_C <- hclust(chowdary_dis_C, method = "single")
clust3_C <- hclust(chowdary_dis_C, method = "complete")
plot(clust1_C, main = "Colon samples using Average linkage")
recommended_cut_off_height <- mean(clust1_C$height) + 3*sd(clust1_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust3_C, main = "Colon samples using Complete linkage")
recommended_cut_off_height <- mean(clust3_C$height) + 3*sd(clust3_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust2_C, main = "Colon samples using single linkage")
recommended_cut_off_height <- mean(clust2_C$height) + 3*sd(clust2_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

# RAND
library("flexclust")


clust1_label <- cutree(clust1_B, k=8)
clust3_label <- cutree(clust3_B, k=4)
table(clust1_label, clust3_label)
randIndex(clust1_label, clust3_label)

clust1_label <- cutree(clust1_C, k=5)
clust3_label <- cutree(clust3_C, k=5)
table(clust1_label, clust3_label)
randIndex(clust1_label, clust3_label)

library(dendextend)
library(khroma)

mypal <- colour("okabeito")(8)[c(2:8, 1)]

dend1 <- as.dendrogram(clust1_B)
dend2 <- as.dendrogram(clust3_B)

dend1 <- set(dend1, "branches_k_color", value = mypal[1:3], k = 8)
dend2 <- set(dend2, "branches_k_color", value = mypal[4:6], k = 4)

tanglegram(dend1, dend2, lab.cex=NA, lwd=0.5, faster=TRUE, main_left = "Average Linkage, k=8",main_right = "Complete Linkage, k=4")


dend1 <- as.dendrogram(clust1_C)
dend2 <- as.dendrogram(clust3_C)

dend1 <- set(dend1, "branches_k_color", value = mypal[1:3], k = 5)
dend2 <- set(dend2, "branches_k_color", value = mypal[4:6], k = 5)

tanglegram(dend1, dend2, lab.cex=NA, lwd=0.5, faster=TRUE, main_left = "Average Linkage, k=5",main_right = "Complete Linkage, k=5")



#STAAAAAPPPP
#HERRRRRREEEEE
#ywp

chowdary <- read.csv("D:\\Trintiy\\Junior Sophister\\Semester 1\\Multivariate Linear Analysis\\Assignment\\Assignment 1\\chowdary (1).csv")
chowdary_colors <- cbind(chowdary[1:62,], color= c("blue"))
chowdary_colors_temp <- cbind(chowdary[63:104,], color= c("red"))
chowdary_colors <- rbind(chowdary_colors, chowdary_colors_temp)#

column_means <- colMeans(chowdary[, 3:184])
sapply(chowdary[, 3:184],var)
hist(column_means)
range(column_means)

#PART ONE

chowdary_PC_stand <- prcomp(chowdary_colors[, 3:184], scale=TRUE)

print(chowdary_PC_stand)
summary(chowdary_PC_stand)


plot(chowdary_PC_stand, main = "chowdary's Data", type = "l")

chowdary_PC_var_explain <- (chowdary_PC_stand$sdev^2) / (sum(chowdary_PC_stand$sdev^2))
plot(chowdary_PC_var_explain, type = "b", main = "chowdary Data Stand", 
     xlab = "No. of components", ylab = "Proportion of variance explained", xaxt = "n", xlim = c(1, 10) )
axis(1, at = 1:10)

plot(chowdary_colors[,3], chowdary_colors[, 4], col=chowdary_colors[, 185])

barplot(chowdary_PC_stand$rotation[,1], main = "chowdary PC 1")
barplot(chowdary_PC_stand$rotation[,2], main = "chowdary PC 2")
barplot(chowdary_PC_stand$rotation[,3], main = "chowdary PC 3")
barplot(chowdary_PC_stand$rotation[,4], main = "chowdary PC 4")



new_chowdary_stand <- predict(chowdary_PC_stand)

pairs(new_chowdary_stand[ , 1:4], col=chowdary_colors[,185])

plot(new_chowdary_stand[,1], new_chowdary_stand[,2], type="n", xlab="PC1", ylab="PC2")
text(new_chowdary_stand[,1], new_chowdary_stand[,2], labels=substr(chowdary_colors[,2],1,1), col=chowdary_colors[,185])

plot(new_chowdary_stand[,1], new_chowdary_stand[,4], type="n", xlab="PC1", ylab="PC4")
text(new_chowdary_stand[,1], new_chowdary_stand[,4], labels=substr(chowdary_colors[,2],1,1), col=chowdary_colors[,185])


#PART TWO

chowdary_B_norm <- chowdary[1:62, 3:184]

#chowdary_B_norm <- chowdary[3:62, 3:184]

chowdary_C_norm <- chowdary[63:104, 3:184]

chowdary_B_sd <- apply(chowdary_B_norm, 2 ,sd)
chowdary_C_sd <- apply(chowdary_C_norm, 2 ,sd)

chowdary_B <- sweep(chowdary_B_norm, 2, chowdary_B_sd, "/")
chowdary_C <- sweep(chowdary_C_norm, 2, chowdary_C_sd, "/")


chowdary_dis_B <- dist(chowdary_B, method = "minkowski", p=1)
chowdary_dis_C <- dist(chowdary_C, method = "minkowski", p=1)
chowdary_dis_mat_B <- as.matrix(chowdary_dis_B)
chowdary_dis_mat_C <- as.matrix(chowdary_dis_C)

#B
clust1_B <- hclust(chowdary_dis_B, method = "average")
clust2_B <- hclust(chowdary_dis_B, method = "single")
clust3_B <- hclust(chowdary_dis_B, method = "complete")
plot(clust1_B, main = "Breast samples using average linkage", xlab = "Index", ylab = "Height")
recommended_cut_off_height <- mean(clust1_B$height) + 3*sd(clust1_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust3_B, main = "Breast samples using Complete linkage")
recommended_cut_off_height <- mean(clust3_B$height) + 3*sd(clust3_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust2_B, main = "Breast samples using single linkage")
recommended_cut_off_height <- mean(clust2_B$height) + 3*sd(clust2_B$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

#C
clust1_C <- hclust(chowdary_dis_C, method = "average")
clust2_C <- hclust(chowdary_dis_C, method = "single")
clust3_C <- hclust(chowdary_dis_C, method = "complete")
plot(clust1_C, main = "Colon samples using Average linkage")
recommended_cut_off_height <- mean(clust1_C$height) + 3*sd(clust1_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust3_C, main = "Colon samples using Complete linkage")
recommended_cut_off_height <- mean(clust3_C$height) + 3*sd(clust3_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)

plot(clust2_C, main = "Colon samples using single linkage")
recommended_cut_off_height <- mean(clust2_C$height) + 3*sd(clust2_C$height)
abline(h = recommended_cut_off_height, lty = 2, col = 2)



