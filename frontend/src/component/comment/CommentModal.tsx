import React, { useEffect } from 'react';

import post from '../../assets/post2.png';

interface CommentModalProps {
  showModal: boolean;
  onClose: () => void;
  className: String;
}

const CommentModal: React.FC = ({ showModal, onClose, className }) => {
  // const handleGetAllComment = async() =>{
  //     const response = await
  // };

  return (
    <div className={`relative bg-yellow-200 w-[500px] h-[100vh] ${className}`}>
      <img src={post} className="w-[400px] h-[450px]" />
    </div>
  );
};

export default CommentModal;
