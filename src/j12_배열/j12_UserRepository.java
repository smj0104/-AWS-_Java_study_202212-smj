package j12_배열;

//repository 저장소  (응집도가 높은 경우)
//repository를 통해서 배열을 받아온다
public class j12_UserRepository {

	private j12_User[] userTable;

	public j12_UserRepository(j12_User[] userTable) { // 전체생성자 constructor usingfields
		this.userTable = userTable;
	}

	public j12_User[] getUserTable() {
		return userTable;
	}

	public void saveUser(j12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;

	}

	private void extendArray(int length) {
		j12_User[] newArray = new j12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void extendArrayOne() {
		j12_User[] newArray = new j12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void transferDataToNewArray(j12_User[] oldArray, j12_User[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public j12_User finduserByUserName(String username) {  //선형탐색
		
	j12_User user = null;  //항상 null 체크하기
		
		for(j12_User u : userTable) {
			if(u == null) {
				continue;
			}
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
}
