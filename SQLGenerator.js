// Requiring fs module in which writeFile function is defined. 
const fs = require('fs') 


// NOTE: The next 2 functions (random name generator) worth of code was pulled from another users github.  He allows it to be used as long as you keep his credit above the code.
/*
(c) by Thomas Konings
Random Name Generator for Javascript
*/

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

function generateName(){
	var name1 = [ "Adam", "Adel", "Alex", "Alexio", "Andrew", "Andy", "Aaron", "Anthony", "Ben", "Benny", "Billy", "Bob", "Brian", "Carl", "Charles", "Christopher", "Daniel", "Dan", "Danny", "David", "Donald", "Edward", "Erin", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "James", "JD", "John", "Johnny", "Joseph", "Jack", "Joe", "Joshua", "Kenneth", "Kevin", "Larry", "Master", "Michael", "Marky", "Matt", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Pauly", "Paulino", "Peter", "Richard", "Robert", "Ronald", "Roger", "Russel", "Sherman", "Steve", "Steven", "Thomas", "Tim", "Timothy", "Tom", "Tommy", "Ty", "Victor", "Walter", "William"];
	var name2 = ["Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler" ];

	var name = name1[getRandomInt(0, name1.length)] + ' ' + name2[getRandomInt(0, name2.length)];
	return name;

}

//this function adds a 0 when needed
function addZero(i){
    if(i < 10){
        i = '0' + i;
    }
    return i;
}

//generates a random birthday
function generateBirthday(){
    var returnMe = getRandomNumber(20, 1970) + '-' + addZero(getRandomNumber(12, 1)) + '-' + addZero(getRandomNumber(28, 1))
    return returnMe;
}
  
//returns a random number between (max - 1) and min
function getRandomNumber(max, min){
    return Math.floor((Math.random() * max) + min);
}


//used to get the team name
function getTeam(getTeam){
    if(getTeam == 1){
        return "Arizona Cardinals"
    }
    else if(getTeam == 2){
        return "Atlanta Falcons"
    }
    else if(getTeam == 3){
        return "Carolina Panthers"
    }
    else if(getTeam == 4){
        return "Chicago Bears"
    }
    else if(getTeam == 5){
        return "Dallas Cowboys"
    }
    else if(getTeam == 6){
        return "Detroit Lions"
    }
    else if(getTeam == 7){
        return "Green Bay Packers"
    }
    else if(getTeam == 8){
        return "Los Angeles Rams"
    }
    else if(getTeam == 9){
        return "Minnesota Vikings"
    }
    else if(getTeam == 10){
        return "New Orleans Saints"
    }
    else if(getTeam == 11){
        return "New York Giants"
    }
    else if(getTeam == 12){
        return "Philadelphia Eagles"
    }
    else if(getTeam == 13){
        return "San Fransisco 49ers"
    }
    else if(getTeam == 14){
        return "Seattle Seahawks"
    }
    else if(getTeam == 15){
        return "Tampa Bay Buccaneers"
    }
    else if(getTeam == 16){
        return "Washington Football Team"
    }
    else if(getTeam == 17){
        return "Baltimore Ravens"
    }
    else if(getTeam == 18){
        return "Buffalo Bills"
    }
    else if(getTeam == 19){
        return "Cincinnati Bengals"
    }
    else if(getTeam == 20){
        return "Cleveland Browns"
    }
    else if(getTeam == 21){
        return "Denver Broncos"
    }
    else if(getTeam == 22){
        return "Houston Texans"
    }
    else if(getTeam == 23){
        return "Indianapolis Colts"
    }
    else if(getTeam == 24){
        return "Jacksonville Jaguars"
    }
    else if(getTeam == 25){
        return "Kansas City Chiefs"
    }
    else if(getTeam == 26){
        return "Las Vegas Raiders"
    }
    else if(getTeam == 27){
        return "Los Angeles Chargers"
    }
    else if(getTeam == 28){
        return "Miami Dolphins"
    }
    else if(getTeam == 29){
        return "New England Patriots"
    }
    else if(getTeam == 30){
        return "New York Jets"
    }
    else if(getTeam == 31){
        return "Pittsburgh Steelers"
    }
    else if(getTeam == 32){
        return "Tennessee Titans"
    }
    else {
        return "Error"
    }

}

// used to get the position
function getJob(jobNumber){
    if(jobNumber == 1){
        return "Linebacker"
    }
    else if(jobNumber == 2){
        return "Linebacker"
    }
    else if(jobNumber == 3){
        return "Linebacker"
    }
    else if(jobNumber == 4){
        return "Defensive Back"
    }
    else if(jobNumber == 5){
        return "Defensive Back"
    }
    else if(jobNumber == 6){
        return "Safety"
    }
    else if(jobNumber == 7){
        return "Defensive Guard"
    }
    else if(jobNumber == 8){
        return "Defensive Guard"
    }
    else if(jobNumber == 9){
        return "Tackle"
    }
    else if(jobNumber == 10){
        return "Tackle"
    }
    else if(jobNumber == 11){
        return "Nose Guard"
    }
    else if(jobNumber == 12){
        return "Running Back"
    }
    else if(jobNumber == 13){
        return "Running Back"
    }
    else if(jobNumber == 14){
        return "Wide Receiver"
    }
    else if(jobNumber == 15){
        return "Wide Receiver"
    }
    else if(jobNumber == 16){
        return "Offensive Guard"
    }
    else if(jobNumber == 17){
        return "Offensive Guard"
    }
    else if(jobNumber == 18){
        return "Offensive Tackle"
    }
    else if(jobNumber == 19){
        return "Offensive Tackle"
    }
    else if(jobNumber == 20){
        return "Center"
    }
    else if(jobNumber == 21){
        return "Tight End"
    }
    else if(jobNumber == 22){
        return "Tight End"
    }
    else if(jobNumber == 23){
        return "Quarterback"
    }
    else{
        return "guards"
    }
}

//calling this function generates the whole insert file piece by piece
function generateData(){
    let returnString  = generateTeamsAndCoaches(10);
        returnString += generateOffensivePlayers(10);
        returnString += generateDefensivePlayers(10);
        returnString += generateQuarterbacks(10);
    return returnString;
}

//generates data for the Teams table
function generateTeamsAndCoaches(Seasons){
    //base insert statements and comments are added here
    let string = '';
    let CoachString =  '\n \n \n -- Coaches are inserted here\n'; 
    let TeamString  =  '-- Teams are inserted here\n'; 
    CoachString += 'INSERT INTO Head_Coach VALUES \n'
    TeamString  += 'INSERT INTO Team VALUES \n'
    let wins = 0;
    let draws = 0;
    for(let i = 1; i < 33; i++){
        this.superBowlWins = getRandomNumber(6, 0);
        this.coachName = generateName();
        TeamString  += '-- ' + getTeam(i) + '\n';
        CoachString += '-- ' + getTeam(i) + '\n';
        for(let j = 1; j <= Seasons; j++){
            //this gives a different team an additional superbowl win once per year
            if(j == i){
                this.superBowlWins++;
            }
            draws = getRandomNumber(4, 0)
            wins = getRandomNumber( (17 - draws), 0)
            //team string is added to here
            TeamString += '( "' + getTeam(i) + '", ' + wins + ', ' + (16-wins-draws) + ', ' + draws + ', ' + this.superBowlWins + ', ' + (2010 + j) + ' ), \n';
            //coach string is added to here
            CoachString += '( "' + this.coachName + '", ' + this.superBowlWins + ', ' + (2010 + j) + ', "' + getTeam(i) + '" ), \n';
        }
    }
    //this code removes the , from the last line and closes the insert statement
    CoachString = CoachString.slice(0, -3)
    CoachString += '\n;\n\n'
    TeamString = TeamString.slice(0, -3)
    TeamString += '\n;\n\n'
    string = TeamString + CoachString;
    return string;
}

//generates numLines number of insert statements
function generateOffensivePlayers(Seasons){
    //base insert statements and comments are added here
    let string = '\n \n \n -- Offensive players are inserted here\n'; 
    string += 'INSERT INTO Offensive_Player VALUES \n'
    for(let i = 1; i < 33; i++){
        
        this.job = getJob(i);
        string += '-- ' + getTeam(i) + '\n';
        for(let j = 12; j <= 22; j++){
            //generate players name, birthday, and jersey number
            let birthday      = generateBirthday()
            let playerName    = generateName();
            let jerseyNumber  = getRandomNumber(99, 0);            
            string += '-- Player: ' + playerName + '\n'
            for(let k = 1; k <= Seasons; k++){                
                //numbers are generated here
                if(this.job == 16 || this.job == 17 || this.job == 18 || this.job == 19 || this.job == 20){
                    this.touchdowns = 0;
                    this.rushingYards = 0;
                    this.turnOvers = 0;
                }
                else
                {
                    this.touchdowns = getRandomNumber(10, 0);
                    this.rushingYards = getRandomNumber(100, 0);
                    this.turnOvers = getRandomNumber(10, 0);
                }
                this.passingYards  = getRandomNumber(3, 0);
                //string is filled with data here
                string += '( "' + playerName + '", "' + birthday + '", ' + jerseyNumber + ', ' + this.touchdowns + ', ' + this.passingYards + ', ' + this.rushingYards + ', ' +  this.turnOvers + ', "' +  getJob(j)  + '", ' +  (2010 + k)  + ', "' +  getTeam(i) + '"), \n';
            }
        }
    }
    //this code removes the , from the last line and closes the insert statement
    string = string.slice(0, -3)
    string += '\n;\n\n'
    return string;
}

//generates numLines number of insert statements
function generateDefensivePlayers(Seasons){
    //base insert statements and comments are added here
    let string = '\n \n \n -- Defensive players are inserted here\n'; 
    string += 'INSERT INTO Defensive_Player VALUES \n'
    for(let i = 1; i < 33; i++){
        
        this.job = getJob(i);
        string += '-- ' + getTeam(i) + '\n';
        for(let j = 1; j <= 11; j++){
            //generate players name, birthday, and jersey number
            let birthday      = generateBirthday()
            let playerName    = generateName();
            let jerseyNumber  = getRandomNumber(99, 0);            
            string += '-- Player: ' + playerName + '\n'
            for(let k = 1; k <= Seasons; k++){                
                //numbers are generated here, the if statements makes sure that stats are distributed to different jobs properly
                if(this.job == 7 || this.job == 8 || this.job == 9 || this.job == 10 || this.job == 11){
                this.touchdowns = 0;
                }
                else
                {
                    this.touchdowns = getRandomNumber(5, 0);
                }
                this.sacks         = getRandomNumber(10, 0);
                this.rushingYards  = getRandomNumber(10, 0);
                this.tackles       = getRandomNumber(20, 0);
                if(this.job == 9 || this.job == 10 || this.job == 11){
                    this.interceptions = getRandomNumber(1, 0);
                }
                else
                {
                    this.interceptions = getRandomNumber(20, 0);
                }
                
                //string is filled with data here
                string += '( "' + playerName + '", "' + birthday + '", ' + jerseyNumber + ', ' + this.touchdowns + ', ' + this.rushingYards + ', ' + this.sacks + ', ' +  this.tackles + ', ' + this.interceptions + ', "' +  getJob(j)  + '", ' +  (2010 + k)  + ', "' +  getTeam(i) + '"), \n';
            }
        }
    }
    //this code removes the , from the last line and closes the insert statement
    string = string.slice(0, -3)
    string += '\n;\n\n'
    return string;
}

//generates numLines number of insert statements
function generateQuarterbacks(Seasons){
    //base insert statements and comments are added here
    let string = '\n \n \n -- Quarterbacks are inserted here \n'; 
    string += 'INSERT INTO Quarterback VALUES \n'
    for(let i = 1; i < 33; i++){
        //generate players name, birthday, and jersey number
        let birthday      = generateBirthday()
        let playerName    = generateName();
        let jerseyNumber  = getRandomNumber(99, 0);
        this.job = getJob(23);
        string += '-- ' + getTeam(i) + '\n';
        string += '-- Quarterback: ' + playerName + '\n'     
        for(let j = 1; j <= Seasons; j++){     

            //numbers are generated here
            this.passingYards     = getRandomNumber(2000, 1000);
            this.rushingYards     = getRandomNumber(400, 100);
            this.timesSacked      = getRandomNumber(20, 5);
            this.interceptions    = getRandomNumber(20, 5);
            this.fumbles          = getRandomNumber(20, 5);      
            this.passingTD        = getRandomNumber(100, 20);
            this.rushingTD        = getRandomNumber(100, 20);
            this.completionPerc   = getRandomNumber(50, 20);
            this.passesAttempted  = getRandomNumber(200, 100);
            this.passesCompleted  = this.passesAttempted + getRandomNumber(200, 50);       
                   
            string += '-- Season: ' + (1999+j) + '\n'
            //string is filled with data here
            string += '( "' + playerName + '", "' + birthday + '", ' + jerseyNumber + ', ' + this.passingYards + ', ' + this.rushingYards + ', ' + this.timesSacked + ', ' +  this.interceptions + ', ' + this.fumbles + ', ' +  this.passingTD + ', ' +  this.rushingTD + ', ' +  this.completionPerc + ', ' +  this.passesAttempted + ', ' +  this.passesCompleted + ', "' +  this.job  + '", ' +  (2010 + j)  + ', "' +  getTeam(i) + '"), \n';
        }
    }
    //this code removes the , from the last line and closes the insert statement
    string = string.slice(0, -3)
    string += '\n;\n\n'
    return string;
}

// Data which will write in a file. 
let data1 = generateData();

// Write data in 'hw9-data-10000.sql'
generateFiles('Teams.sql', data1)

// This code generates the files
function generateFiles(name, data){    
    fs.writeFile(name, data, (err) => {       
        // In case of a error throw err. 
        if (err) throw err; 
    }) 
}