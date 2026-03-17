# Backend Setup (Firebase Firestore)

App now supports a real backend through Firebase Firestore.

## 1) Firebase project connect karein
1. Firebase Console me project banayein.
2. Android app add karein with package: `com.apna.darzi`.
3. `google-services.json` download karke `app/google-services.json` me place karein.

## 2) Firestore collections create karein

### `shops` collection
Document fields:
- `id` (number)
- `title` (string)
- `studioName` (string)
- `rating` (number)
- `price` (number)
- `deliveryDays` (number)

### `chats` collection
Document fields:
- `id` (number)
- `name` (string)
- `lastMessage` (string)
- `time` (string)

### `profiles` collection
Document id: `current_user`
Fields:
- `fullName` (string)
- `email` (string)
- `dob` (string)
- `phone` (string)

## 3) Runtime behavior
- Agar Firebase configured hai, app Firestore listeners use karegi.
- Agar Firebase configured nahi hai, app automatically fake local repository pe fallback karegi.
