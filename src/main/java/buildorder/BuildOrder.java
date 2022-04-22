package buildorder;

import java.util.ArrayList;
import java.util.List;

public class BuildOrder {
	
	public static List<String> sortBuilds(String[] builds, String[][] dependencies) throws NoValidOrderException {
		ArrayList<String> buildList = new ArrayList<String>(); // create the build order list
		int loop = 0; // needed for determining build validity 
		while(buildList.size()!= builds.length) {
			for(int i = 0; i < builds.length; i++) {
				boolean flag = true; // needed for signaling build addition
				
				// skipping the build if already present in build order list
				if(buildList.contains(builds[i])) {
					continue;
				}
				
				// cycle through dependencies and determine if current build is capable of being added
				for(int j=0; j < dependencies.length; j++) {
					if(builds[i] == dependencies[j][1] && !buildList.contains(dependencies[j][0])) {
						flag = false; // flagged false until valid build is found
					}
				}
				
				// adding valid build to order
				if(flag) {
					buildList.add(builds[i]);
				}
				
			}
			
			// validity check of build order
			loop++;
			if(loop == builds.length*2) {
				throw new NoValidOrderException(); // custom exception created
			}
		}
		
		return buildList; // returns build order
	}

	public static void main(String[] args) throws NoValidOrderException {
		
		/**
		 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). 
		 * All of a project’s dependencies must be built before the project is. Find a build order that will allow the projects to be built. 
		 * If there is no valid build order, return an error.
		 * 
		 * Input
		 * projects:      a, b, c, d, e, f
		 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) 
		 * Expected Output:        f, e, a, b, d, c
		 * 
		 */
		
		String[] builds = new String[] {"a","b","c","d","e","f","g"};
		String[][] dependencies = new String[][] {{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
		System.out.println(sortBuilds(builds,dependencies));
	}

}
