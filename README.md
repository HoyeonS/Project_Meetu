# MEETU <img src="https://github.com/HoyeonS/Project_Meetu/blob/7c6a214b8a0dc4453184a0d466fe1a5d489a1652/logo.png" width="3%"></img> 
Android Application Project with Android Studio.
> # project worked in "7 Platoon KCU"
> Dedicated release Date April 2023
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#how-to-use">HOW IT WORKS FOR USERS</a></li>
      </ul>
    </li>
    <li>
      <a href="#logics-and-algorithms">Logics and Algorithms</a>
      <ul>
        <li><a href="#pick-logic">Pick Logic</a></li>
        <li><a href="#priority-based-calculation">Priority Based Calculation</a></li>
        <li><a href="#mapping">Mapping</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project
This project is making mobile application in android studio targetting UW-MADISON students
and helping users to find their soulmates based on their informations.

The name "MEETU" is originated from combination of term "Meet" and "You(U)".

<img src="https://github.com/HoyeonS/Project_Meetu/blob/87d247a9c09a27da7e9a7e1ee0ddd3fcf2b02977/Intro.png"></img>

## Matching system have following steps:
> * evaluating the "relationship score" between users and users based on collected information 
> * sorting list of other users based on their priority (priority = relationship score)
> * giving recommendation of college mates based on following sorted list

### How To Use

MAKE ACCOUNT for system:

## information needed for sign up / login:
> * wiscID

TO USE matching system:

## Users may need to give following 8 informations used for matching algorithm:
> * College Years
> * Majors
> * Favorite Space(1)
> * Favorite Space(2)
> * Where You lives Near From
> * Language Preference
> * Favorite Food
> * Hobby


## Following other informations needed for user's profiles:
> * Brief message introducing user
> * Contact information

## Logics And Algorithms:
Through transportation of user's information to the cloud and with algorithm calculation with PriorityQueue, MEETU returns the recommended friend's lists to the users.

<img src="https://github.com/HoyeonS/Project_Meetu/blob/ebb0d564dbafec0b84cc1faa9d37bdc50708d334/Principle_origin.png"></img>

User 8 informations pass through following architecture with combination of 3 steps (layers) and are translated into other users lists for recommendation.

**Following 3 steps:**
> * Pick Logic
> * mapping
> * Priority Based Calculation

<img src="https://github.com/HoyeonS/Project_Meetu/blob/c05394571833daec136050a92e9089cc1d542067/Algorithm.png"></img>

### Pick Logic 

Pick Logic works for check and generate related information from the input user information.
> For example: 
>
> Input user information: 
> * Computer Science B.S.
>
> Output information: 
> * Computer Science B.S. (with score 1) 
> * other major related to computer science B.S. (with score between 0.1 to 1)


Pick Logic algorithm plays following two rules:
* 1. Transport the resulted information list to mapping
* 2. Evaluate the score based on information comparsion between mapped other users' informations and user's information

### Priority Based Calculation
Priority score is based on the calculation:
<img src="https://github.com/HoyeonS/Project_Meetu/blob/d6bb2f8091023b9cffc7bff788fab8bfcdf43e60/Formula.png"></img>
Sum of the scores for each categories (whether the information is matched and "friendly for users" or not)

if the category information is included in friendly from "pick logic layer" => W_x 

> * W_x can be between 1 to 0 depened on "how friendly between two informations (one from user and one from other user)"
if not => 0
> * WN is weight for relative importance between categories

  
### Mapping
** Simplest part of the algorithm **

MySql Database student table storing users' informations -> **MEETU SERVER**

Mapping algorithm get information from the MEETU database based on information get from pick logic layers as a key

<img src="https://github.com/HoyeonS/Project_Meetu/blob/ca6a1176f8ab172bd0974a707594536cf91f7980/Mapping.png"></img>


## Contact

# TEAM KCU: 7소대 
**Android Back-End Developers**: 
> * 임재성 [@Jaesung411](https://github.com/Jaesung411)
> * 강제임스 [@JamesKang003](https://github.com/JamesKang003)

**Android Front-End Developers**: 
> * 정원준 [@WonjunWilliamJung](https://github.com/WonjunWilliamJung)
> * 박준형 [@JunyungPark](https://github.com/JunyungPark)

**Algorithm Designers**: 
> * 손호연 [@HoyeonS](https://github.com/HoyeonS)
> * 강제임스 [@JamesKang003](https://github.com/JamesKang003)

**Web Service Deployer**: 
> * 손호연 [@HoyeonS](https://github.com/HoyeonS)
> * 임재성 [@Jaesung411](https://github.com/Jaesung411)

**Scrum Manager**:
> * 손호연 [@HoyeonS](https://github.com/HoyeonS)


**ANY QUESTIONS?** -> Hoyeonsohn@icloud.com
