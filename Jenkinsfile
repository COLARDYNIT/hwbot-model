stage('build'){
	node {
    	mvnHome = tool 'M3'
    	JAVA_HOME = tool 'java 8'
    	checkout scm
    	sh "'${mvnHome}/bin/mvn' clean compile -Pci -Dmaven.test.skip"
    	archive 'target/*.jar'
    }
}

stage('test: unit'){
	node {
		sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -Dspring.profiles.active=ci test -Pci"
		junit '**/target/surefire-reports/TEST-*.xml'
	}
}

stage('deploy: repo'){
	input "Deploy on repo?"
	echo "Deploying on repo"
	node {
		mvnHome = tool 'M3'
		sh "'${mvnHome}/bin/mvn' versions:set"
		sh "'${mvnHome}/bin/mvn' -Dmaven.test.skip -DskipTests versions:set deploy"
		sh "'${mvnHome}/bin/mvn' scm:tag"
	}
}
